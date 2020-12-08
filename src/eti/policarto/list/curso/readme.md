# Met�dos Relevantes / List #
## By Alura ##

Al�m do m�todo sort() que vimos neste cap�tulo, a classe Collections tamb�m possui muitos outros m�todos interessantes. Vamos dar uma olhada em alguns:

```Collections.reverse()```
O m�todo reverse() serve para inverter a ordem de uma lista. As vezes precisamos imprimir uma lista de nomes do �ltimo para o primeiro, ou uma lista de ids do maior para o menor e � nestas horas que utilizamos o reverse para inverter a ordem natural da lista para n�s.

```Collections.shuffle()```
O m�todo shuffle() serve para embaralhar a ordem de uma lista. Por exemplo em um caso de um sistema de sorteio, em que precisamos de uma ordem aleat�ria na nossa lista, utilizamos o m�todo shuffle para embaralh�-la.

```Collections.singletonList()```
O m�todo singletonList() nos devolve uma lista imut�vel que cont�m um �nico elemento especificado. Ele � �til quando precisamos passar um �nico elemento para uma API que s� aceita uma Collections daquele elemento.

```Collections.nCopies()```
O m�todo nCopies() nos retorna uma lista imut�vel com a quantidade escolhida de um determinado elemento. Se temos uma lista espec�fica e precisamos obter uma outra lista imut�vel , contendo diversas c�pias de um destes objetos, utilizamos o m�todo nCopies(). O bom deste m�todo � que mesmo que n�s solicitemos uma lista com um n�mero grande, como 10000 objetos, ele na verdade se referencia a apenas um, ocupando assim um pequeno espa�o.

Este m�todo tamb�m � utilizado para inicializar Listas rec�m criadas com Null, j� que ele pode rapidamente criar diversos objetos, deste modo:

List<Type> list = new ArrayList<Type>(Collections.nCopies(1000, (Type)null));

Estes s�o apenas alguns exemplos dos diversos m�todos da classe Collections.