{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf610
{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;\red0\green0\blue0;\red193\green193\blue193;
}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;\csgray\c0\c0;\cssrgb\c80000\c80000\c80000;
}
\paperw11900\paperh16840\margl1440\margr1440\vieww25400\viewh14580\viewkind0
\deftab720
\pard\pardeftab720\sl300\partightenfactor0

\f0\fs26 \cf2 \cb3 \expnd0\expndtw0\kerning0
import base64\
import json\
\
import googleapiclient.discovery\
\
def tag_with_creator(event, context):\
    """Adds a custom metadata entry for a new virtual machine.\
\
    Triggered by a Cloud Pub/Sub message containing a Compute Engine\
    audit activity Stackdriver log message\
    """\
    pubsub_message = base64.b64decode(event['data']).decode('utf-8')\
    msg_json = json.loads(pubsub_message)\
    proto_payload = msg_json['protoPayload']\
    resource_name = proto_payload['resourceName']\
    email = proto_payload['authenticationInfo']['principalEmail']\
\
    # compute engine API\
    compute = googleapiclient.discovery.build(\
        'compute', 'v1', cache_discovery=False)\
\
    # full name is of the form\
    # projects/$PROJ_NAME/zones/$ZONE/instances/$INST_NAME\
    name_tokens = resource_name.split('/')\
    project = name_tokens[1]\
    zone = name_tokens[3]\
    instance_name = name_tokens[5]\
\
    # need to get current vm metadata before we can update it\
    vm_details = compute.instances().get(\
        project=project, zone=zone, instance=instance_name).execute()\
    vm_metadata = vm_details['metadata']\
\
    # add/replace metadata item\
    _update_metadata(vm_metadata, 'creator', email)\
    response = compute.instances().setMetadata(\
        project=project, zone=zone, instance=instance_name,\
        body=vm_metadata).execute()\
    print('Updated metadata for resource %s' % resource_name)\
\
def _update_metadata(vm_meta, key, value):\
    """Update existing vm metadata with the supplied key/value pair.\
\
    If the key already exists, value is overwritten.\
    """\
    if 'items' not in vm_meta:\
        vm_meta['items'] = []\
\
    for item in vm_meta['items']:\
        if item['key'] == key:\
            item['value'] = value\
            return\
    vm_meta['items'].append(\{\
        'key': key,\
        'value': value\
    \})\
}