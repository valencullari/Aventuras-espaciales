

TP Integrador: Aventuras Espaciales 

Se desea crear un juego de aventuras espaciales donde el jugador asume el papel de un explorador que viaja por distintos planetas, recolecta recursos, enfrenta peligros espaciales y ayuda a reparar una estación espacial dañada. El objetivo del juego será completar todas las misiones de entrega de recursos antes de que la nave quede destruida.

---

1. Inicio del juego 

Al comenzar el juego, el jugador deberá ingresar su nombre.

El jugador comenzará con:

* Energía al 100%.


* 0 créditos espaciales.


* Una nave espacial elegida por el usuario.



La nave comenzará con:

* Vida al 100%.


* Una bodega vacía para transportar recursos.



### Naves disponibles

El usuario deberá elegir una nave espacial entre las siguientes opciones:

1. 
**Fénix** 


* 
**Velocidad:** Alta 


* 
**Capacidad de carga:** 50 toneladas 


* 
**Vida inicial:** 100% 




2. 
**Eclipse** 


* 
**Velocidad:** Media 


* 
**Capacidad de carga:** 100 toneladas 


* 
**Vida inicial:** 100% 




3. 
**Galaxian** 


* 
**Velocidad:** Baja 


* 
**Capacidad de carga:** 150 toneladas 


* 
**Vida inicial:** 100% 





> 
> **Nota:** Antes de mostrar cualquier menú, el programa deberá informar: nombre del jugador , energía actual , créditos espaciales , nombre de la nave , velocidad de la nave , vida de la nave , capacidad máxima de carga de la nave y la carga actualmente ocupada en la bodega.
> 
> 

---

2. Base espacial 

Luego de elegir la nave, el jugador comenzará en la base espacial. Desde allí se podrá elegir entre las siguientes opciones:

1. Viajar a un planeta 


2. Ver bodega de carga 


3. Vender recursos 


4. Ver misiones disponibles 


5. Entregar recursos para una misión 


6. Reparar nave 


7. Descansar 


8. Salir del juego 



* 
**Descansar:** Recupera la energía del jugador al 100%.


* 
**Reparar nave:** Permite recuperar vida de la nave. Cada 10% de vida reparada cuesta 25 créditos espaciales. El jugador deberá indicar cuántos tramos de 10% desea reparar, sin superar el 100% de vida. Si no tiene créditos suficientes, no podrá realizar la reparación.



---

3. Planetas disponibles 

El jugador podrá viajar a tres tipos de planetas:

1. 
**Planeta rocoso** 


* Mineral común: 60% 


* Cristal: 25% 


* Núcleo energético: 15% 




2. 
**Planeta gaseoso** 


* Gas: 60% 


* Plasma: 25% 


* Cristal: 15% 




3. 
**Planeta volcánico** 


* Lava: 50% 


* Obsidiana: 30% 


* Núcleo energético: 20% 





Al viajar a un planeta, el jugador se situará en él y dispondrá de las siguientes opciones:

1. Minar 


2. Viajar a otro planeta 


3. Volver a la base 



---

4. Recursos 

Cada vez que el jugador mine, se generará un recurso según las probabilidades del planeta actual.

| Recurso | Peso | Valor de venta |
| --- | --- | --- |
| <br>**Mineral común** 

 | 10 toneladas 

 | 10 créditos 

 |
| <br>**Gas** 

 | 20 toneladas 

 | 15 créditos 

 |
| <br>**Lava** 

 | 30 toneladas 

 | 20 créditos 

 |
| <br>**Cristal** 

 | 15 toneladas 

 | 35 créditos 

 |
| <br>**Plasma** 

 | 25 toneladas 

 | 45 créditos 

 |
| <br>**Obsidiana** 

 | 25 toneladas 

 | 50 créditos 

 |
| <br>**Núcleo energético** 

 | 40 toneladas 

 | 80 créditos 

 |

* 
**Mecánica de minado:** Minar consume una cantidad aleatoria de energía, entre el 10% y el 25%. Primero se calcula cuánta energía requiere la acción; si el jugador la tiene, se descuenta y se genera el recurso. Si no cuenta con suficiente energía, la acción no se realiza y se le indicará volver a la base a descansar.


* 
**Límite de carga:** La nave no puede superar su capacidad máxima. Si el recurso encontrado no entra en la bodega, se perderá y la energía utilizada no se recuperará.



---

5. Bodega de carga 

La nave cuenta con una bodega basada en un `ArrayList` para almacenar los recursos recolectados. Sus responsabilidades principales son:

* Almacenar los recursos recolectados.


* Mostrar los recursos que contiene (e informar si está vacía).


* Calcular la carga total ocupada.


* Verificar si un nuevo recurso entra según la capacidad máxima.


* Retirar recursos cuando sean vendidos o entregados en misiones.



---

6. Venta de recursos 

Desde la base, el jugador podrá vender sus recursos almacenados a cambio de los créditos correspondientes. El programa debe permitir:

1. Vender un recurso específico.


2. Vender todos los recursos almacenados en la bodega.



> Tras la venta, los recursos deberán ser removidos de la bodega de la nave.
> 
> 

---

7. Misiones de entrega 

Para reparar los sistemas de la estación espacial, el jugador podrá consultar y completar misiones desde la base. El programa mostrará el nombre, recursos requeridos, recompensa y estado (pendiente/completada) de cada una:

* 
**Misión 1: Reparación del casco exterior** 


* Requerimientos: 3 minerales comunes , 1 cristal.


* Recompensa: 120 créditos espaciales.




* 
**Misión 2: Estabilización del reactor** 


* Requerimientos: 2 gases , 1 plasma.


* Recompensa: 170 créditos espaciales.




* 
**Misión 3: Núcleo de energía principal** 


* Requerimientos: 1 núcleo energético , 2 obsidianas.


* Recompensa: 250 créditos espaciales.





> 
> **Reglas:** Una misión solo se completa si se tienen todos los recursos en la bodega. Al completarse, se remueven los recursos , se otorga la recompensa , se marca como completada y no se puede volver a entregar.
> 
> 

---

8. Viajes y peligros espaciales 

Cada vez que el jugador viaje a un planeta o cambie entre ellos, puede ocurrir un evento de peligro. La probabilidad depende de la velocidad de la nave (asociada a su `enum` correspondiente):

* 
**Velocidad Alta:** 20% de probabilidad de peligro.


* 
**Velocidad Media:** 40% de probabilidad de peligro.


* 
**Velocidad Baja:** 60% de probabilidad de peligro.



Si se activa un peligro, se generará uno de forma aleatoria:

1. 
**Pirata espacial:** Causa entre 3% y 15% de daño. Si la nave es de velocidad alta, el daño se duplica.


2. 
**Renegado:** Causa entre 3% y 15% de daño. Si la nave es de velocidad baja, el daño se duplica.


3. 
**Tormenta cósmica:** Causa entre 5% y 20% de daño a cualquier tipo de nave.



> El daño recibido se informará siempre por consola. Si la vida de la nave llega a 0%, el jugador pierde el juego.
> 
> 

---

9. Condiciones de victoria y derrota 

* 
**Victoria:** El jugador gana únicamente al completar las 3 misiones de entrega.


* 
**Derrota:** El jugador pierde si la vida de la nave llega a 0%.


* 
**Salida Voluntaria:** Se puede salir del juego desde el menú de la base.



Al finalizar, se mostrará un resumen con el nombre del jugador , nave utilizada , créditos obtenidos , misiones completadas , recursos sobrantes en la bodega y el resultado final.

---

10. Requisitos técnicos 

El proyecto debe respetar estrictamente los siguientes criterios de desarrollo:

* 
**Estructura Orientada a Objetos:** Organización en clases con responsabilidades claras; prohibido resolver toda la lógica en la clase principal.


* 
**Encapsulamiento:** Uso correcto de modificadores de acceso (`private`, `protected`, `public`). Los getters y setters deben usarse solo cuando sea necesario.


* 
**Relaciones:** Aplicar conceptos de composición , herencia y polimorfismo.


* 
**Uso de Enums:** La velocidad de la nave debe modelarse con un `enum` que asocie su probabilidad de peligro.


* 
**Colecciones:** Estructura de bodega resuelta mediante `ArrayList`.


* 
**Validaciones:** Controlar correctamente el ingreso de datos del usuario y evitar que variables como vida, energía o carga salgan de sus rangos válidos.


* 
**Clases de utilidad:** Uso de al menos una clase con métodos estáticos para operaciones generales (ej. números aleatorios o validaciones auxiliares).



---

11. Entregables 

1. 
**Diagrama de clases UML** 


* Debe permitir comprender el diseño general del sistema antes de revisar el código.


* Debe incluir las clases principales , atributos y métodos clave , relaciones de herencia , composición/asociación , enums , relación jugador-nave-bodega y el uso de `ArrayList`.




2. 
**Proyecto Java** 


* Código fuente completo, limpio, que compile y ejecute sin errores.


* Debe respetar de forma razonable el diseño planteado en el diagrama UML.





---

12. Bonus opcional 

Mejoras visuales y auditivas que se pueden incorporar (siempre que la funcionalidad principal sea correcta y estable):

* Uso de colores en la consola para mensajes importantes (compatible con IntelliJ).


* Efectos de sonido simples para acciones (minar, recibir daño, completar misiones, etc.).


* Música de fondo durante la partida. Los archivos de audio deben estar dentro del proyecto con rutas relativas y poder detenerse limpiamente al finalizar el programa. Su uso no debe comprometer la compilación ni requiere obligatoriamente el uso de hilos.
