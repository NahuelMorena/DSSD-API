Cuando habran esta rama en eclipse les va a aparecer con errores.
Apartir de esta rama hay que hacer lo siguiente para que eclipse no marque el proyecto con errores:

#Descargar lombok e instalarlo

https://projectlombok.org/download
Esto nos va a descargar un .jar. Le hacemos doble click y nos habre el instalador.
El instalador va a detectar el IDE que tenemos instalado, en mi caso eclipse.
Le damos a instalar, luego cerramos y abrimos eclipse. Podemos comprobar que se instaló
en help-> about eclipse IDE. Ahí al fondo del texto debe aparecer la version de lombok.

#Instalar las nuevas dependencias de gradle.

1) Yo lo hice con el comando: gradle --refresh-dependencies
2) En eclipse darle click derecho al proyecto y luego ir a Gradle -> Refresh gradle project.
3) Por si acaso luego en la pestaña "Project" de eclipse darle a "Clean".

Ahora el proyecto de eclipse tendra en cuenta los paquetes y ademas la sintaxis de lombok.

#Docker
Probablemente va a ser necesario borrar las imagenes de Docker y volver a crearlas con Docker compose up

#Como funciona jwt

-Al ejecutar la aplicacion se nos crea automaticamente un usuario en la base de datos.
-Ahora todos los endpoints necesitan token jwt o daran error 403 forbidden.

Tenemos dos endpoints no protegidos que nos devuelvene el token jwt: 

#Login

http://localhost:8080/api/auth/login
Recibe las credenciales y devuelve el token jwt

#Register

http://localhost:8080/api/auth/register
Recibe las credenciales, crea un nuevo usuario y devuelve el token jwt.

-Ambas son de metodo POST
-Ambas reciben un JSON que necesita los siguientes campos: 
{
    "username": "string",
    "password": "string
}

#Swagger
Luego en swagger vamos a ver que en los endpoints aparece un candado. En ese candado le podemos poner el token jwt que consigamos de los endpoints anteriores. Una ves hacemos eso ya podemos consultar los endpoints normalmente hasta que expire el token.



