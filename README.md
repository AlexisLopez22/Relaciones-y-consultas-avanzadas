Relacion y consultas avanzadas

Descripción
Aplicación que organiza notas por categorías usando Room con relación 1:N. También permite realizar búsquedas avanzadas.

Descargar el código

git clone https://github.com/AlexisLopez22/Relaciones-y-consultas-avanzadas.git

Opción B (ZIP): Haz clic en el botón verde Code > Download ZIP y extrae la carpeta en tu escritorio.

2. Abrir en Android Studio
Abre Android Studio.

Selecciona File > Open.

Busca la carpeta que acabas de descargar/descomprimir y dale a OK.

3. Sincronizar el Proyecto
Android Studio comenzará a configurar el proyecto automáticamente.

Espera a que termine la barra de carga en la parte inferior derecha.

Si ves un botón que dice "Sync Now" o un elefante gris en la barra de herramientas, dale clic para descargar las dependencias necesarias.

4. Ejecutar la App
Conecta tu celular por USB o inicia un Emulador en Android Studio.


Estructura de la base de datos
Entidad Category (tabla: categories)

category_id, category_name

Entidad Note (tabla: notes)

note_id, note_title ,note_content ,created_at

category_id (FK → categories.category_id)


Relación

1 categoría → muchas notas
(Relación 1:N entre Category y Note.)


DAO – Operaciones avanzadas

Obtener notas por categoría

Buscar notas por texto usando LIKE


Listo disfrute lo que logre con videos de youtube su propio codigo de libros

