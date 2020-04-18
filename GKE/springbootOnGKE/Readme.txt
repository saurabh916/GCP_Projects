1) clone the code from this GitHub repo to your GCP cloud shell. This is a simple springboot application to demonstrate 
   deployment of spring boot based docker container on GKE cluster.
   
2) build docker image by running the command "docker build -t sbongke:v1.0 ."

3) run the the image "docker run -d -p 8095:8095 sbongke:v1.0"

4) Go to preview mode and check the running application on port 8095. At the end of the url give the path /gketest.

5) Now stop the container and create an image to be pushed to Google Container Registry(gcr) by running the command "docker build
   -t gcr.io/$DEVSHELL_PROJECT_ID/sbongke:v1.0 ."
   
6) Push the image to gcr by running the command "gcloud docker -- push gcr.io/$DEVSHELL_PROJECT_ID/sbongke:v1.0"

7) Go to your GCP console and click on Container Registry. You should see an entry for sbongke:v1.0 .

8) Till now we have created a spring boot project, containerized it inside docker container and pushed it to GCP Container Registry.
   Now we will create a Kubernetes cluster to deployer our docker container

9) Run the command in the cloud shell "gcloud container clusters create my-k8s-cluster --zone=asia-south1-a" . By default, 
  a 3 node cluster is created. We can also define the no of nodes while running the above command.
  
10) Now we create a workload to deploy our container by running this command "kubectl run k8s-workload --image=<path of your imagein gcr>
     --port=8095
     
 11) Now expose your application to exteral world through HTTP loadbalancer "kubectl expose deployment k8s-workload --type=LoadBalancer"
 
 12) After a while, the GKE will provide you an URL ending with 8095, click on it and append /gketest at the end of it. 
  You should get the message "Hi there, this is from GKE". Your application is now deployed and running on GKE.
  
