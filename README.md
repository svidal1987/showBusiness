# ShowBusiness
Proyecto generado para dar respuesta a la tecnica solicitada por personal de Meli.
[Documento de deficion](https://drive.google.com/file/d/1xQKLU9mc2m6xhHYs5fgVRxl3lqtkhOXY/view?usp=sharing).

### Descarga del codigo
Previamente tener instalado git, posteriror:
~~~
git clone https://github.com/svidal1987/showBusiness.git
~~~
### Compilado del codigo
Previamente tener instalado maven y java, posteriror:
~~~
cd showBusiness
mvn clean package
~~~
### Ejecucion
~~~
cd target
java -jar tecnica-0.0.1-SNAPSHOT.jar
~~~
# Descripcion de la solicion
En la implementacion se proponen endpints:  
-**Login**: Permite el inicio de session mediante JWT, con el cual se validara usuario de acuerdo a su ROL (ADMIN, PORTAL)  
-**Consulta de Shows**: permite obtener los SHows dado un rango de fecha y precio, u otros parametros como el establecimiento, funcion o el mismo show puntual a ver  
-**Consulta de Funcion**: permite obtener las Dunciones dado un rango de fecha y precio, u otros parametros como el establecimiento, show o la misma funcion a visualizar.  
-**Consulta de disponibilidad**: permite consulta la disponibilidad de una funcion.  
-**Asignacion de ticket**: permite a los portales asignar el ticket a un cliente particular.  


![Texto alternativo]([https://drive.google.com/file/d/1yMI8VaRaW-tZ7ywMnIPizpK1GUWmso2S/view?usp=sharing](https://drive.google.com/file/d/1yMI8VaRaW-tZ7ywMnIPizpK1GUWmso2S/view?usp=sharing))
