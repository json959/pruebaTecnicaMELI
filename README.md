# pruebameli
Prueba tecnica para meli


INSTRUCCIONES DE USO:

1. Configuracion de ambiente:
  1.1 ejecutar el archivo pruebaMeli.sql que se encuentra en la ruta \src\main\resources\databaseScripts, en un servidor de base de datos MySql.
  
  ![image](https://user-images.githubusercontent.com/18233646/142969728-521e211f-a0eb-43ab-a265-f577c3995e6d.png)

  1.2 clonar el proyecto de esta mismo repositorio desde la rama master, importar el proyecto tipo mvn en su ide de preferencia,  a continuacion algunas recomendaciones.
    
   1.2.1 INTELLJ IDEA (recomendado)  https://programmerclick.com/article/91991750038/
          NETBEANS https://vaadin.com/learn/tutorials/import-maven-project-netbeans
          ECLIPCE https://programmerclick.com/article/9399850313/
          vsCode https://vaadin.com/learn/tutorials/vs-code-for-java-and-maven-projects
          
   1.3 luego de tener importado y construido el proyecto, debemos buscar el el boton de ejecucion e iniciar el proyecto.
      se deberia ver al final las siguientes lineas, las cuales nos indican que el proyecto fue iniciado.
   
   ![image](https://user-images.githubusercontent.com/18233646/142970737-d3b3a4e6-deb1-4200-9a75-55e3b82c80ea.png)

  1.4 luego de tener el proyecto iniciado, pasaremos al uso de [postman](https://www.postman.com/downloads/) , donde importaremos la coleccion Prueba meli services.postman_collection.json  que se encuentra en \src\main\resources\postmanCollections.
  
   1.4.1 Como importar https://kb.datamotion.com/?ht_kb=postman-instructions-for-exporting-and-importing.
    
   1.4.2 nos deberia quedar la coleccion de postman de esta forma.
    
   ![image](https://user-images.githubusercontent.com/18233646/142971352-9976409b-a468-4576-b44c-6e3975c890dc.png)
    
   1.4.3 El request de tipo POST es la referente a validar si el DNA ingresadoe smutante o no, recibira un json con un array de String en este formato 
          "["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]", tal cual se muestr aen la imagen.
    
   ![image](https://user-images.githubusercontent.com/18233646/142971549-9d2feb8f-ec58-4334-b84a-ce9e538040ce.png)

   1.4.4 el request de tipo GET hace referencia a las estaditicas  no recibe parametros , simplemente se esjecuta la peticiony obtendremos la respuesta del promedio de los DNA.
    
   ![image](https://user-images.githubusercontent.com/18233646/142972518-8191966b-f6a9-484a-ad7d-91a86d1a366c.png)

    
    

    
 
  
