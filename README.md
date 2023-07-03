
##How to start the app

 - k3d cluster create mycluster -p "8080:80@loadbalancer"
 -  kubectl apply -f namespace.yaml 

 - kubectl apply -f postgres.yaml 

 - kubectl apply -f ingress.yaml 

 - kubectl config set-context --current --namespace=javapg

 - http://localhost:8080/ in your browser

 



