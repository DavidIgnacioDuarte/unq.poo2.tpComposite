# Trabajo Pr�ctico � Composite


Presentaci�n del patr�n de dise�o **Composite** junto a sus diferentes implementaciones y usos dentro de un programa.


## Introducci�n

Tomando como referencia el libro **Design Patterns** de  _Gamma et al._ :

* **En la intenci�n del patr�n se indica que el cliente debe poder tratar de manera uniforme tanto a objetos individuales como compuestos. �C�mo se logra esto con el patr�n Composite?** Tal y como expresa el libro, "la clave de este patr�n es una clase abstracta que representa tanto a primitivas como a sus contenedores". Esto se logra componiendo cada objeto en una estructura de **�rbol** y trabajar con cada uno como si fuera un objeto individual. Al recorrer, si el objeto en cuesti�n es individual se efect�a la acci�n sobre este; si es compuesto, se efect�a la acci�n sobre cada individual que contiene.


* **Explique en qu� casos aplicar�a el patr�n:** El patr�n aplicar�a en caso de querer representar una jerarqu�as de objetos parte-todo, y cuando los clientes sean capaces de obviar las diferencias entre composiciones de objetos y los objetos individuales.


* **Dentro de las consecuencias, se indica que los clientes deben mantenerse simples y no deben ser conscientes si est�n interactuando con un objeto hoja o una composici�n. �Qu� elementos de la programaci�n orientada a objetos hacen posible esto?** Esto es posible gracias al **polimorfismo** y al binding din�mico.


### Ejercicio "Cultivos"

* **�Que impacto genera en su dise�o el hecho de compartir instancias de parcelas entre composiciones? Es decir, que la misma instancia se encuentre en mas de una composicion:** En el actual dominio no hay impactos significativos, y en cuanto a las hojas, no les afecta en lo m�s m�nimo. Sin embargo, puede generarse un loop infinito debido a la recursi�n en el caso en que un objeto compuesto contenga otro compuesto, y as� sucesivamente. 


* **Describa las alternativas que puede utilizar para calcular la ganancia anual. Relacione las alternativas:** En mi c�digo, hice uso de una ganancia anual general para cada uno de los objetos que ocupan una parcela, pudiendo a la vez acceder a la ganancia anual de cada cultivo individual en el caso de que sea una "hoja" de un cultivo mixto, preguntando por cada instancia. Esta soluci�n puede ser problem�tica en el caso de agregar m�s objetos individuales y no ser�a flexible. Pero no se me ocurre otra soluci�n mejor de modo tal que pueda consultarse esto �ltimo y se mantenga el **polimorfismo** entre el objeto compuesto y el objeto individual.


* **Explique la discusi�n sobre qui�nes deben implementar las operaciones de agregado y borrado de hijos:** Esta decisi�n es debatible por los siguientes puntos: En primer lugar, definir la gesti�n del agregado y borrado directamente en la ra�z nos da transparencia, puesto que podemos tratar a todos los componentes de manera uniforme. Sin embargo, sacrifica la seguridad, ya que los clientes pueden intentar hacer cosas sin sentido, como a�adir y eliminar objetos de lsa hojas. Por otro lado, definir la gesti�n de los hijos en la clase compuesta nos proporciona seguridad, ya que cualquier intento de a�adir o eliminar objetos de las hojas ser� detectado en tiempo de compilaci�n en un lenguaje est�ticamente tipado, como en este caso, JAVA. Pero perdemos transparencia, porque las hojas y los compuestos tienen diferentes protocolos.


* **Sobre su implementaci�n, indique los roles que desempe�an cada una de las clases dise�adas en relaci�n al patr�n Composite:** COMPOSITE -> PorcionProductivaDeTierra. OBJETO COMPUESTO -> CultivoMixto. HOJA -> CultivoSoja y CultivoTrigo.
 


