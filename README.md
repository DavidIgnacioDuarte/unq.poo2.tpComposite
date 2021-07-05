# Trabajo Práctico – Composite


Presentación del patrón de diseño **Composite** junto a sus diferentes implementaciones y usos dentro de un programa.


## Introducción

Tomando como referencia el libro **Design Patterns** de  _Gamma et al._ :

* **En la intención del patrón se indica que el cliente debe poder tratar de manera uniforme tanto a objetos individuales como compuestos. ¿Cómo se logra esto con el patrón Composite?** Tal y como expresa el libro, "la clave de este patrón es una clase abstracta que representa tanto a primitivas como a sus contenedores". Esto se logra componiendo cada objeto en una estructura de **árbol** y trabajar con cada uno como si fuera un objeto individual. Al recorrer, si el objeto en cuestión es individual se efectúa la acción sobre este; si es compuesto, se efectúa la acción sobre cada individual que contiene.


* **Explique en qué casos aplicaría el patrón:** El patrón aplicaría en caso de querer representar una jerarquías de objetos parte-todo, y cuando los clientes sean capaces de obviar las diferencias entre composiciones de objetos y los objetos individuales.


* **Dentro de las consecuencias, se indica que los clientes deben mantenerse simples y no deben ser conscientes si están interactuando con un objeto hoja o una composición. ¿Qué elementos de la programación orientada a objetos hacen posible esto?** Esto es posible gracias al **polimorfismo** y al binding dinámico.


### Ejercicio "Cultivos"

* **¿Que impacto genera en su diseño el hecho de compartir instancias de parcelas entre composiciones? Es decir, que la misma instancia se encuentre en mas de una composicion:** En el actual dominio no hay impactos significativos, y en cuanto a las hojas, no les afecta en lo más mínimo. Sin embargo, puede generarse un loop infinito debido a la recursión en el caso en que un objeto compuesto contenga otro compuesto, y así sucesivamente. 


* **Describa las alternativas que puede utilizar para calcular la ganancia anual. Relacione las alternativas:** En mi código, hice uso de una ganancia anual general para cada uno de los objetos que ocupan una parcela, pudiendo a la vez acceder a la ganancia anual de cada cultivo individual en el caso de que sea una "hoja" de un cultivo mixto, preguntando por cada instancia. Esta solución puede ser problemática en el caso de agregar más objetos individuales y no sería flexible. Pero no se me ocurre otra solución mejor de modo tal que pueda consultarse esto último y se mantenga el **polimorfismo** entre el objeto compuesto y el objeto individual.


* **Explique la discusión sobre quiénes deben implementar las operaciones de agregado y borrado de hijos:** Esta decisión es debatible por los siguientes puntos: En primer lugar, definir la gestión del agregado y borrado directamente en la raíz nos da transparencia, puesto que podemos tratar a todos los componentes de manera uniforme. Sin embargo, sacrifica la seguridad, ya que los clientes pueden intentar hacer cosas sin sentido, como añadir y eliminar objetos de lsa hojas. Por otro lado, definir la gestión de los hijos en la clase compuesta nos proporciona seguridad, ya que cualquier intento de añadir o eliminar objetos de las hojas será detectado en tiempo de compilación en un lenguaje estáticamente tipado, como en este caso, JAVA. Pero perdemos transparencia, porque las hojas y los compuestos tienen diferentes protocolos.


* **Sobre su implementación, indique los roles que desempeñan cada una de las clases diseñadas en relación al patrón Composite:** COMPOSITE -> PorcionProductivaDeTierra. OBJETO COMPUESTO -> CultivoMixto. HOJA -> CultivoSoja y CultivoTrigo.
 


