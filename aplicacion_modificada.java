import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class aplicacion extends JFrame {

        // Lista de palabras clave de eventos históricos de la informática
        private static final String[] palabrasClave = {
                        "Eniac", "Fortran", "ARPANET", "UNIX", "World Wide Web", "Java", "Intel 4004", "iPhone",
                        "Big Data",
                        "Linux", "Cloud Computing"
        };

        // Lista de descripciones históricas y avances
        private static final String[] descripciones = {
                        "1945: Eniac, El proyecto ENIAC (Computador e Integrador Numérico Electrónico), originalmente conocido como “Proyecto PX”, se diseñó y construyó entre 1943 y 1945 en la escuela Moore, de la Universidad de Pensilvania. En él trabajaron John Mauchly y John Presper Eckert, junto a un equipo de ingenieros que incluía a Robert F. , .",
                        "1950: Fortran, Fortran fué el primer lenguaje de alto nivel imperativo. Su principal uso en esa decada fue para aplicaciones número-científicas para la IBM 704. Posteriormente se utilizó para estructuras de control, funciones, memoria dinámica, comentarios y sub-rutinas..",
                        "1969: ARPANET,El 5 de diciembre de 1969 se establecía la primera interconexión de ARPANET entre los nodos ubicados en la Universidad de California en Los Ángeles, el Stanford Research Institute, la Universidad de California en Santa Barbara y la Universidad de Utah..",
                        "1983: UNIX,Solo los sistemas operativos totalmente compatibles y que se encuentran certificados por la especificación Single UNIX Specification pueden ser denominados \"UNIX®\" (otros reciben la denominación «similar a un sistema Unix» o «similar a Unix»). En ocasiones, suele usarse el término \"Unix tradicional\" para referirse a Unix o a un sistema operativo que cuenta con las características de UNIX Versión 7 o UNIX System V o unix versión 6..",
                        "1991: World Wide Web, La World Wide Web (WWW o conocida como la Web) es un medio global de información donde los usuarios pueden leer y escribir a través de computadoras conectadas a Internet. El término es a menudo usado erróneamente como sinónimo de Internet. Se trata de un servicio que opera sobre la red de Internet, como el correo electrónico. La historia de Internet comienza antes que la existencia de la World Wide Web. .",
                        "1995: Java, Java es un lenguaje de programación y una plataforma informática que fue comercializada por primera vez en 1995 por Sun Microsystems.2​3​\r\n"
                                        + //
                                        "\r\n" + //
                                        "El lenguaje de programación Java fue desarrollado originalmente por James Gosling, de Sun Microsystems (constituida en 1983 y posteriormente adquirida el 27 de enero de 2010 por la compañía Oracle),4​ y publicado en 1995 como un componente fundamental de la plataforma Java de Sun Microsystems. Su sintaxis deriva en gran medida de C y C++, pero tiene menos utilidades de bajo nivel que cualquiera de ellos. Las aplicaciones de Java son compiladas a bytecode (clase Java), que puede ejecutarse en cualquier máquina virtual Java (JVM) sin importar la arquitectura de la computadora subyacente. .",
                        "1971: Intel 4004,El 4004 fue lanzado en un paquete de 16 pines CERDIP el 15 de noviembre de 1971. El 4004 fue el primer procesador de computadora diseñado y fabricado por el fabricante de chips Intel, quien previamente hacía semiconductores de chips de memoria. ​ Marcian \"Ted\" Hoff formuló la propuesta arquitectónica en 1969.",
                        "2007: iPhone,Apple anunció el iPhone en enero de 2007,3​ tras varios rumores y especulaciones que circulaban desde hacía meses.4​ El iPhone se introdujo a la venta inicialmente el 29 de junio de 2007.1​ Fue nombrado «Invento del año» por la revista Time en 2007.5​ Tuvo un precio de salida de 499 USD, solo disponible con la operadora AT&T en EE. UU.6 .",
                        "2010s: Big Data,Los primeros registros de uso de datos para rastrear y controlar negocios datan de hace más de 7.000 años. Cuando se introdujo la contabilidad en Mesopotamia para registrar el crecimiento de cultivos y rebaños. Con el tiempo los principios contables continuaron mejorando. Así que en 1663, John Graunt registró y examinó toda la información sobre los roles de mortalidad en Londres. Él quería comprender y construir un sistema de alerta para la peste bubónica en curso. En el primer registro de análisis de datos estadísticos, reunió sus hallazgos en el libro “Observaciones naturales y políticas”. Hechas sobre las facturas de mortalidad, que proporciona grandes conocimientos sobre las causas de muerte en el siglo XVII.  .",
                        "1991: Linux,Linux comienza en 1991 como un proyecto personal del estudiante finés Linus Torvalds: crear un nuevo núcleo de un sistema operativo libre. El núcleo Linux resultante ha estado marcado por un crecimiento constante a lo largo de su historia. Desde el lanzamiento inicial de su código fuente en 1991, ha crecido de una pequeña cantidad de archivos C bajo una licencia que prohíbe la distribución comercial a la versión 5.6 en 2020, con más de 33,14 millones de líneas de código fuente, sin contar comentarios,1​ bajo la Licencia Pública General de GNU v2. .",
                        "2000s: Cloud Computing,La computación en la nube (del inglés cloud computing),1​ conocida también como servicios en la nube, informática en la nube, nube de cómputo o simplemente «la nube», es el uso de una red de servidores remotos conectados a internet para almacenar, administrar y procesar datos, servidores, bases de datos, redes y software. En lugar de depender de un servicio físico instalado, se tiene acceso a una estructura donde el software y el hardware están virtualmente integrados. ."

        };

        // Lista de años de los eventos para mostrar una línea de tiempo simple
        private static final int[] años = {
                        1945, 1950, 1969, 1983, 1991, 1995, 1971, 2007, 2010, 1991, 2000
        };

        private CardLayout cardLayout;
        private JPanel panelCards;
        private ArrayList<Libro> libros;

        // Clase interna para representar un libro
        class Libro {
                private String titulo;
                private String autor;
                private String categoria;

                public Libro(String titulo, String autor, String categoria) {
                        this.titulo = titulo;
                        this.autor = autor;
                        this.categoria = categoria;
                }

                public String getTitulo() {
                        return titulo;
                }

                public String getAutor() {
                        return autor;
                }

                public String getCategoria() {
                        return categoria;
                }
        }

        // Constructor
        public aplicacion() {
                // Configuración de la ventana
                setTitle("Historia de la Informática");
                setSize(1000, 800);
                setLocationRelativeTo(null); // Centra la ventana
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Inicializar la lista de libros
                libros = new ArrayList<>();
                listaLibros();

                // Layout principal: usaremos CardLayout para cambiar entre pantallas
                cardLayout = new CardLayout();
                panelCards = new JPanel(cardLayout);

                // Pantalla principal de bienvenida
                JPanel pantallaBienvenida = crearPantallaBienvenida();
                panelCards.add(pantallaBienvenida, "PantallaBienvenida");

                // Pantalla de Historia de la Informática
                JPanel pantallaHistoria = crearPantallaHistoria();
                panelCards.add(pantallaHistoria, "Historia");

                // Pantalla de Tipos de Computadoras
                JPanel pantallaTipos = crearPantallaTipos();
                panelCards.add(pantallaTipos, "Tipos");

                // Pantalla de Libros
                JPanel pantallaLibros = crearPantallaLibros();
                panelCards.add(pantallaLibros, "Libros");

                // Agregar el panel de Cards a la ventana principal
                add(panelCards);
        }

        private JPanel crearPantallaBienvenida() {
                JPanel pantallaBienvenida = new JPanel();
                pantallaBienvenida.setLayout(new BorderLayout());
                JLabel bienvenidaLabel = new JLabel("Bienvenido a la Historia de la Informática ",
                                SwingConstants.CENTER);
                bienvenidaLabel.setFont(new Font("Arial", Font.BOLD, 45));
                pantallaBienvenida.add(bienvenidaLabel, BorderLayout.CENTER);

                // Botones para navegar entre pantallas
                JPanel botonesPanel = new JPanel();
                JButton historiaButton = new JButton("Historia de la Informática");
                JButton tiposButton = new JButton("Tipos de Computadoras");
                JButton lineaDeTiempoButton = new JButton("Línea de Tiempo");
                JButton buscadorButton = new JButton("Buscador de Eventos");
                JButton librosButton = new JButton("Libros");
                JButton salirButton = new JButton("Salir");

                botonesPanel.add(historiaButton);
                botonesPanel.add(tiposButton);
                botonesPanel.add(lineaDeTiempoButton);
                botonesPanel.add(buscadorButton);
                botonesPanel.add(librosButton);
                botonesPanel.add(salirButton);
                pantallaBienvenida.add(botonesPanel, BorderLayout.SOUTH);

                // Acciones de los botones
                historiaButton.addActionListener(e -> cardLayout.show(panelCards, "Historia"));
                tiposButton.addActionListener(e -> cardLayout.show(panelCards, "Tipos"));
                lineaDeTiempoButton.addActionListener(e -> mostrarLineaDeTiempo());
                buscadorButton.addActionListener(e -> mostrarBuscador());
                librosButton.addActionListener(e -> cardLayout.show(panelCards, "Libros"));
                salirButton.addActionListener(e -> System.exit(0));

                return pantallaBienvenida;
        }

        private JPanel crearPantallaHistoria() {
                JPanel pantallaHistoria = new JPanel();
                pantallaHistoria.setLayout(new BorderLayout());
                JTextArea areaTexto = new JTextArea();
                areaTexto.setEditable(false);
                areaTexto.setText(
                                "1. 1936: Alan Turing es el científico que en 1936 creó la máquina de Turing, que formalizó los conceptos de algoritmo y computación, y es considerado uno de los padres de la ciencia de la computación y precursor de la informática moderna: \r\n"
                                                + //
                                                "La máquina de Turing era capaz de resolver cualquier problema matemático que se pudiera representar mediante un algoritmo. \r\n"
                                                + //
                                                "La versión que Turing formuló de la máquina de Turing es ampliamente aceptada como la tesis de Church-Turing (1936). \r\n"
                                                + //
                                                "Turing también encabezó el equipo que ideó la máquina Bombe y varios equipos electrónicos Colossus, que algunos consideran los primeros computadores de la historia. \r\n"
                                                + //
                                                "Durante la Segunda Guerra Mundial, Turing trabajó en descifrar los códigos nazis, lo que salvó millones de vidas. Sin embargo, la intransigencia de la época lo convirtió en un paria y acabó con su vida. .\n"
                                                + "2. 1945: El proyecto ENIAC (Computador e Integrador Numérico Electrónico), originalmente conocido como “Proyecto PX”, se diseñó y construyó entre 1943 y 1945 en la escuela Moore, de la Universidad de Pensilvania. En él trabajaron John Mauchly y John Presper Eckert, junto a un equipo de ingenieros que incluía a Robert F..\n"
                                                + "3. 1950-1960: La UNIVAC I La UNIVAC I (UNIVersal Automatic Computer I, Computadora Automática Universal I) fue la primera computadora comercial fabricada en Estados Unidos, entregada el 31 de marzo de 1951 a la oficina del censo. Fue diseñada principalmente por J. Presper Eckert y John William Mauchly, autores de la primera computadora electrónica estadounidense, la ENIAC. Durante los años previos a la aparición de sus sucesoras, la máquina fue simplemente conocida como «UNIVAC». Se donó finalmente a la universidad de Harvard y Pensilvania.\r\n"
                                                + //
                                                "\r\n" + //
                                                "La Z3 de 1941 fue el primer computador operativo, los anteriores fueron proyectos militares como el ENIAC de 1946 u ordenadores de uso específico, mientras que el UNIVAC I compitió por ser el primer ordenador de uso general vendido comercialmente, pero perdió por un par de meses ante el británico Ferranti Mark 1 vendido en febrero de 1951. Pero en Alemania el Z4 se adelantó a ambos en 1950, el primero en todo el mundo vendido comercialmente...\n"
                                                + "5. 1990-2000: La historia de las computadoras personales u ordenadores personales como dispositivos electrónicos de consumo para el mercado masivo comenzó en 1977 con la introducción de las microcomputadoras, aunque ya se habían aplicado mucho antes, algunas computadoras mainframe y computadoras centrales como sistemas monousuario. Una computadora personal está orientada al uso individual y se diferencia de una computadora mainframe, donde las peticiones del usuario final son filtradas a través del personal de operación o un sistema de tiempo compartido, en el cual un procesador grande es compartido por pocos individuos. Después del desarrollo del microprocesador, las computadoras personales llegaron a ser más económicas y se popularizaron; las primeras de ellas, generalmente llamadas «microcomputadoras», fueron vendidas a menudo como kit electrónicos y en números limitados. Fueron de interés principalmente para aficionados y técnicos..\n"
                                                + "6. 2000-presente: Evolución de la tecnología en los últimos 20 años\r\n"
                                                + //
                                                "Teléfonos inteligentes:\r\n" + //
                                                "Al comienzo eran aparatos de gran tamaño, pantallas pequeñas, un poco pesados ​​y poco accesibles.\r\n"
                                                + //
                                                "\r\n" + //
                                                "Fue en el 2007 cuando salió al mercado el primer teléfono de pantalla táctil, de allí en adelante han surgido versiones que varían en calidad, precio y uso.\r\n"
                                                + //
                                                "\r\n" + //
                                                "Ya el smartphone se ha convertido en el amigo leal de las personas ya que desde allí pueden hacer todas sus transacciones bancarias, mantenerse en comunicación con sus seres queridos e incluso realizar reuniones de trabajo.\r\n"
                                                + //
                                                "\r\n" + //
                                                "Dispositivos de memoria USB:\r\n" + //
                                                "Permite almacenar fácilmente datos, vídeos y fotos.\r\n" + //
                                                "\r\n" + //
                                                "Surge en el 2000 por IBM y desplazó notablemente a los disquetes no solo en almacenamiento sino también en tamaño, practicidad y precio.\r\n"
                                                + //
                                                "\r\n" + //
                                                "Google:\r\n" + //
                                                "Es el motor de búsqueda más usado y conocido desde su lanzamiento.\r\n"
                                                + //
                                                "\r\n" + //
                                                "Revolucionó la forma en que realiza las búsquedas de información en línea, además su casa comercial posee otros servicios: Gmail, Docs, entre otros.\r\n"
                                                + //
                                                "Teléfonos inteligentes:\r\n" + //
                                                "Dispositivos de memoria USB:\r\n" + //
                                                "Google:\r\n" + //
                                                "Google Maps:\r\n" + //
                                                "Facebook:\r\n" + //
                                                "Corazón Artificial AbioCor:\r\n" + //
                                                "Velocidad de Internet:\r\n" + //
                                                "Servicios en la nube:");
                pantallaHistoria.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

                JButton backHistoriaButton = new JButton("Volver");
                pantallaHistoria.add(backHistoriaButton, BorderLayout.SOUTH);
                backHistoriaButton.addActionListener(e -> cardLayout.show(panelCards, "PantallaBienvenida"));

                return pantallaHistoria;
        }

        private JPanel crearPantallaTipos() {
                JPanel pantallaTipos = new JPanel();
                pantallaTipos.setLayout(new BorderLayout());
                JTextArea areaTipos = new JTextArea();
                areaTipos.setEditable(false);
                areaTipos.setText("Tipos de Computadoras:\n\n"
                                + "1. Mainframe: Un mainframe es una computadora de alto rendimiento que se utiliza para procesar grandes cantidades de datos y transacciones en tiempo real. También se le conoce como ordenador mainframe o Big Iron. \r\n"
                                + //
                                "Los mainframes son fundamentales para las bases de datos comerciales, los servidores de transacciones y las aplicaciones que requieren seguridad, agilidad y resiliencia. Se utilizan en una gran variedad de sectores, como el comercio electrónico, la banca, la estadística, los navegadores, las universidades y las entidades militares y gubernamentales. \r\n"
                                + //
                                "Algunas de las ventajas de los mainframes son:\r\n" + //

                                "Eficiencia\r\n" + //

                                "Pueden ejecutar múltiples instancias y sistemas operativos simultáneamente.\r\n" + //

                                "Seguridad\r\n" + //

                                "Su sistema de permisos y controles de seguridad hace muy difícil que sean atacados por virus.\r\n"
                                + //
                                "Durabilidad\r\n" + //

                                "Su diseño modular y arquitectura estable les permite funcionar sin interrupciones durante largos períodos de tiempo. \r\n"
                                + //
                                "El término mainframe proviene del gran gabinete, llamado main frame, que albergaba la unidad central de procesamiento y la memoria principal de las primeras computadoras. .\n"

                                + "2. Minicomputadoras: Una minicomputadora es un dispositivo de sobremesa de tamaño pequeño que puede ejecutar un sistema operativo sin necesidad de otros componentes. También se les conoce como mini PC. \r\n"
                                + //
                                "Las minicomputadoras tienen las siguientes características:\r\n" + //

                                "Son más grandes que una computadora de escritorio, pero más pequeñas que un mainframe. \r\n"
                                + //
                                "Son capaces de manejar grandes volúmenes de información. \r\n" + //

                                "Son sistemas multiproceso, lo que significa que pueden soportar de 10 a 200 usuarios simultáneamente. \r\n"
                                + //
                                "Son una opción eficiente energética, por lo que utilizan menos energía. \r\n" + //

                                "Las minicomputadoras se pueden utilizar para:\r\n" + //

                                "Sistemas de punto de venta\r\n" + //

                                "Pantallas de señalización digital\r\n" + //

                                "Computadoras de escritorio de uso general\r\n" + //

                                "Instituciones educativas, como aulas o laboratorios de computación \r\n" + //
                                "\n"

                                + "3. Microcomputadoras: Una microcomputadora es una computadora pequeña que tiene un microprocesador como unidad central de procesamiento (CPU). El microprocesador suele incluir los circuitos de entrada/salida y almacenamiento (o memoria caché) en el mismo chip o circuito integrado. \r\n"
                                + //
                                "Las microcomputadoras, también conocidas como microordenadores u ordenadores personales, son máquinas que han hecho que la informática sea algo cotidiano. Su introducción en 1977 marcó el inicio de la era de las computadoras personales como dispositivos electrónicos de consumo para el mercado masivo. \r\n"
                                + //
                                "Algunas de las primeras microcomputadoras fueron:\r\n" + //

                                "IBM 5100, IBM PC, IBM PCjr, IMSAI 8080, Intellec, Intertec Superbrain. ...\n"

                                + "4. Supercomputadoras: Una supercomputadora es un dispositivo informático que procesa datos a una velocidad muy alta y con una gran potencia de cálculo. Se utiliza para realizar simulaciones y cálculos complejos en campos como la investigación, la inteligencia artificial y la informática de macrodatos. \r\n"
                                + //
                                "Las supercomputadoras se caracterizan por:\r\n" + //

                                "Su alto rendimiento, que se mide en operaciones de punto flotante por segundo (FLOPS) \r\n"
                                + //
                                "Estar compuestas por miles de procesadores interconectados \r\n" + //

                                "Realizar operaciones simultáneas en paralelo \r\n" + //

                                "Requerir un alto consumo de energía y sistemas de enfriamiento especializados \r\n" + //

                                "Algunos de los usos de las supercomputadoras son:\r\n" + //

                                "Modelado y simulación avanzada\r\n" + //

                                "Análisis de datos complejos\r\n" + //

                                "Predicciones científicas\r\n" + //

                                "Investigación en ciencias y tecnología\r\n" + //

                                "Investigación y desarrollo de medicamentos\r\n" + //

                                "Diseño y simulación de productos \r\n" + //

                                "El término \"supercomputadora\" se empezó a utilizar a principios de la década de 1960, cuando IBM lanzó el IBM 7030 Stretch y Sperry Rand presentó el UNIVAC LARC. \r\n"
                                + //

                                "Para clasificar las supercomputadoras más potentes del mundo se utiliza el proyecto Top500, un ranking de las 500 supercomputadoras con mayor rendimiento. \n"

                                + "5. Computadoras portátiles: Un computador portátil o laptop es un equipo personal que puede ser transportado fácilmente. Muchos de ellos están diseñados para soportar software y archivos igual de robustos a los que procesa un computador de escritorio. \r\n"
                                + //

                                "\r\n" + //
                                "Dado que los portátiles se han diseñado para ser transportados fácilmente de un sitio a otro, hay algunas ventajas y diferencias importantes con los computadores de escritorio:\r\n"
                                + //

                                "\r\n" + //
                                "Todo en uno: un portátil tiene todo. Es decir, todo el sistema está integrado: monitor, teclado, touchpad (que sustituye al ratón), altavoces y cámara.\r\n"
                                + //

                                "Independencia: es completamente funcional, incluso cuando no tiene periféricos conectados. Es más rápido de instalar y hay menos cables para conectar.\r\n"
                                + //

                                "Accesorios: también, tienes la opción de conectar un ratón normal, un monitor más grande y otros periféricos.\r\n"
                                + //

                                "Adaptabilidad: esto, básicamente, convierte tu portátil en un ordenador de mesa, con una diferencia principal: puedes desconectar fácilmente los periféricos y llevar el portátil donde quieras.");
                pantallaTipos.add(new JScrollPane(areaTipos), BorderLayout.CENTER);

                JButton backTiposButton = new JButton("Volver");
                pantallaTipos.add(backTiposButton, BorderLayout.SOUTH);
                backTiposButton.addActionListener(e -> cardLayout.show(panelCards, "PantallaBienvenida"));

                return pantallaTipos;
        }

        private JPanel crearPantallaLibros() {
                JPanel pantallaLibros = new JPanel();
                pantallaLibros.setLayout(new BorderLayout());
                JTextArea areaLibros = new JTextArea();
                areaLibros.setEditable(false);
                areaLibros.setText("Lista de Libros:\n\n");
                for (Libro libro : libros) {
                        areaLibros.append(libro.getTitulo() + " - " + libro.getAutor() + " (" + libro.getCategoria()
                                        + ")\n");
                }
                pantallaLibros.add(new JScrollPane(areaLibros), BorderLayout.CENTER);

                JButton backLibrosButton = new JButton("Volver");
                pantallaLibros.add(backLibrosButton, BorderLayout.SOUTH);
                backLibrosButton.addActionListener(e -> cardLayout.show(panelCards, "PantallaBienvenida"));

                return pantallaLibros;
        }

        private void listaLibros() {
                libros.add(new Libro("Computación en la nube Con Google Drive",
                                "Edgar R. Morales Caluña, Fernando X. Altamirano Capelo", "Informatica"));
                libros.add(new Libro(" Historia de la Computación", "Carlos Alberto Garrido López", "Informatica"));
                libros.add(new Libro("manual de la informatica", "Francisco Jose villazan olivarez", "Informatica"));
                libros.add(new Libro("Introducción a las Computadoras", "Universidad Nacional de San Luis",
                                "Informatica"));
                libros.add(new Libro("Introducao a copmputacao", "UAB", "Informatica"));
                libros.add(new Libro("manual de practicas de computacion basica I", "Norma Soriano garibay",
                                "Informatica"));
                libros.add(new Libro("manual de informatica", "Guao", "Informatica"));
                libros.add(new Libro("Introduccion a la computacion", "Sistema Estatal de tele Secundaria",
                                "Informatica"));
                libros.add(new Libro("Introducción a las Computadoras",
                                "Martin Antonio orjuela Velasco y leidy Viviana Cristancho Cruz", "Informatica"));
                libros.add(new Libro("Manual de computacion", "Weebly", "Informatica"));
                libros.add(new Libro("Diccionario de terminos informaticos", "Wikimedia Commons", "Informatica"));
                libros.add(new Libro("Logica y algoritmos", "yois S. Pascuas rengifo", "Informatica"));
                libros.add(new Libro("Algoritmos y presentadores aritmeticos", "Univercidad del pais Vasco",
                                "Informatica"));
                libros.add(new Libro("Algoritmica", "Lolo Roberto Benites cirilo", "Informatica"));
                libros.add(new Libro("algoritmos (presentacion)", "Baños garcia Yesenia y Hernandez Narjera Arancely",
                                "Informatica"));
                libros.add(new Libro("introduccion a los algoritmos", "UDIN Facultad de ingenieria", "Informatica"));
                libros.add(new Libro("Introducion alos algoritmos",
                                "Biomedical engineering laboratory of ceu-San pasblo university", "Informatica"));
                libros.add(new Libro("caracteristicas de los algoritmos (articulo)", "Mario Pastrana Moren",
                                "Informatica"));
                libros.add(new Libro("algorimos y programacion", "Juan Carlos Lopez Garcia", "Informatica"));
                libros.add(new Libro("Algoritmos y programas", "INTEF", "Informatica"));

                // Lista de libros de programación
                libros.add(new Libro("Introducción a la Programación",
                                "Álvarez Escudero Juan Jesús, Andrade Rodríguez Silvia Alejandra, Becerril Palma Marco Antonio",
                                "Programacion"));

                libros.add(new Libro("Programación I Aprender programación orientada a objetos desde cero",
                                "Dra. Ing. Inés Friss de Kereki.", "Programacion"));

                libros.add(new Libro("Introducción a la Programacion", "Aristides Dasso, Ana Funes", "Programacion"));

                libros.add(new Libro("Programación Web del Frontend al Backend",

                                "Ricardo Javier Celí Párraga, Miguel Fabricio Boné Andrade, Aldo Patricio Mora Olivero",
                                "Programacion"));

                libros.add(new Libro("Fundamentos de la programación", "Luis Hernández Yáñez", "Programacion"));

                libros.add(new Libro("Guía de aprendizaje de Programacion", "Joe Llerena Izquierdo", "Programacion"));

                libros.add(new Libro("Algoritmos y programación (guía para docentes)", "Juan Carlos López García",
                                "Programacion"));

                libros.add(new Libro("Introducción a los lenguajes y paradigmas de programación",
                                "Corso, Cynthia; Frias Pablo; Guzman, Analia", "Programacion"));

                libros.add(new Libro("Fundamentos iniciales de lógica de programación I.",
                                "Jairo Hernando Ramírez Marín", "Programacion"));

                libros.add(new Libro("Introducción a la lógica de programación", "María Alejandra Quintero Méndez",
                                "Programacion"));

                libros.add(new Libro("Fundamentos lógicos de la programación",
                                "J. I. García García, P. A. García Sanchez, J. M. Urbano Blanco", "Programacion"));
                libros.add(new Libro("Lógica de programación", "Camilo Augusto Cardona Patiño", "Programacion"));

                libros.add(new Libro("Guía teórica de lógica de programación.", "Uneweb", "Programacion"));

                libros.add(new Libro("El lenguaje de programación C#", "José Antonio González Seco", "Programacion"));

                libros.add(new Libro("El Lenguaje de programación C", "Universidade da Coruña", "Programacion"));

                // Lista de libros de historia de programación
                libros.add(new Libro("Historia de la computacion", " Pablo David Silva", "Historia"));

                libros.add(new Libro("Historia de la computacion", "Gerardo Ignacio Hernandez Garcia", "Historia"));

                libros.add(new Libro("Revolution in the Valley", "Andy Hertzfeld", "Historia"));

                libros.add(new Libro("The Maverick and his machine", "Kevin Maney", "Historia"));

                libros.add(new Libro("Where Wizards Stay Up Late", "Katie Hafner", "Historia"));

                libros.add(new Libro("The Soul of a New Machine", "Tracy Kidder", "Historia"));

                libros.add(new Libro("Alan Turing: The Enigma", "Andrew Hodges", "Historia"));

                libros.add(new Libro("The Computer Boys Take Over", "Wayne Green", "Historia"));

                libros.add(new Libro("Hackers: Heroes of the Computer Revolution", "Steven Levy", "Historia"));

                libros.add(new Libro("The Difference Engine", "William Gibson y Bruce Sterling", "Historia"));

                libros.add(new Libro("The Second Machine Age", "Erik Brynjolfsson", "Historia"));

                libros.add(new Libro("The Innovators", "Walter Isaacson", "Historia"));

                libros.add(new Libro("Life 3.0: Being Human in the Age of Artificial Intelligence", "Max Tegmark",
                                "Historia"));

                libros.add(new Libro("Abundance: The Future is Better Than You Think",
                                "Peter Diamandis y Steven Kotler", "Historia"));

                libros.add(new Libro("Superintelligence: Paths, Dangers, Strategies", "Nick Bostrom", "Historia"));

                libros.add(new Libro("Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "Historia"));

                libros.add(new Libro("Weapons of Math Destruction", "Cathy O'Neil", "Historia"));

                libros.add(new Libro("The Age of Surveillance Capitalism", "Shoshana Zuboff", "Historia"));

                libros.add(new Libro("Brotopia: Breaking Up the Boys' Club of Silicon Valley", "Emily Chang",
                                "Historia"));

                libros.add(new Libro("Ten Arguments for Deleting Your Social Media Accounts", "Jaron Lanier",
                                "Historia"));

                libros.add(new Libro("ENIAC: The Triumphs and Tragedies of the World's First Computer",
                                "Scott McCartney", "Historia"));
        }

        private void mostrarLineaDeTiempo() {
                // Crear el panel principal que contendrá el texto
                JPanel pantallaLineaDeTiempo = new JPanel();
                pantallaLineaDeTiempo.setLayout(new BoxLayout(pantallaLineaDeTiempo, BoxLayout.Y_AXIS));
            
                // Crear el texto de la línea de tiempo como un solo bloque
                String contenidoLineaDeTiempo = 
                    "1940: Primera generación de computadoras\n" +
                    "Las computadoras usaban tubos de vacío y tarjetas perforadas para entrada y salida. Estas máquinas eran enormes y poco fiables.\n\n" +
                    "1945: Eniac, la primera computadora electrónica\n" +
                    "Eniac (Electronic Numerical Integrator and Computer) fue la primera computadora electrónica de propósito general. Diseñada para cálculos de artillería del ejército de los EE.UU., marcó el inicio de la computación moderna.\n\n" +
                    "1951: UNIVAC, la primera computadora comercial\n" +
                    "UNIVAC (Universal Automatic Computer) fue la primera computadora comercial, crucial para la adopción temprana de la computación en empresas y sectores industriales.\n\n" +
                    "1956: Se inventan los discos duros\n" +
                    "IBM introduce el disco duro con su sistema 305 RAMAC, permitiendo almacenamiento magnético con acceso directo a datos.\n\n" +
                    "1965: Gordon Moore introduce la Ley de Moore\n" +
                    "Predice que la cantidad de transistores en un chip se duplicará aproximadamente cada dos años, revolucionando el desarrollo de hardware.\n\n" +
                    "1969: ARPANET, precursor de Internet\n" +
                    "ARPANET, financiada por el Departamento de Defensa de EE. UU., utilizó el protocolo TCP/IP, base de lo que ahora conocemos como Internet.\n\n" +
                    "1971: El microprocesador Intel 4004\n" +
                    "El primer microprocesador comercial del mundo. Este chip permitió la creación de computadoras personales más accesibles y pequeñas.\n\n" +
                    "1981: IBM lanza la PC\n" +
                    "IBM lanza su primera computadora personal, marcando el inicio de una nueva era en la informática doméstica y empresarial.\n\n" +
                    "1983: Microsoft lanza Windows 1.0\n" +
                    "La primera versión de Windows, una interfaz gráfica para MS-DOS. Aunque inicialmente criticada, se convirtió en uno de los sistemas operativos más exitosos.\n\n" +
                    "1991: La World Wide Web se hace pública\n" +
                    "El CERN lanzó la Web al público, transformando cómo interactuamos con la información y dando inicio a la revolución digital.\n\n" +
                    "2000: Y2K, el cambio de milenio\n" +
                    "El mundo tecnológico supera el temido error del año 2000, un problema de software relacionado con la representación de fechas.\n\n" +
                    "2004: Facebook es lanzado\n" +
                    "Fundado por Mark Zuckerberg, Facebook revolucionó la forma en que las personas se comunican y comparten información en línea.\n\n" +
                    "2007: Apple lanza el iPhone\n" +
                    "El iPhone, con su interfaz táctil innovadora, marcó el inicio de una nueva era en la tecnología móvil.\n\n" +
                    "2010: El auge del cloud computing\n" +
                    "Servicios como AWS, Google Cloud y Microsoft Azure transforman la forma en que las empresas manejan la infraestructura tecnológica.\n\n" +
                    "2016: La inteligencia artificial gana terreno\n" +
                    "La IA muestra avances significativos con tecnologías como DeepMind de Google derrotando a campeones mundiales de Go.\n\n" +
                    "2020: Transformación digital acelerada\n" +
                    "La pandemia de COVID-19 acelera la adopción de herramientas digitales, trabajo remoto y educación en línea.\n\n" +
                    "2024: IA generativa en auge\n" +
                    "Modelos de lenguaje como GPT y herramientas como DALL-E transforman la creación de contenido, marcando un hito en la computación inteligente.";
            
                // Crear un JTextArea para mostrar el contenido
                JTextArea textoLineaDeTiempo = new JTextArea(contenidoLineaDeTiempo);
                textoLineaDeTiempo.setLineWrap(true);
                textoLineaDeTiempo.setWrapStyleWord(true);
                textoLineaDeTiempo.setEditable(false);
                textoLineaDeTiempo.setFont(new Font("Serif", Font.PLAIN, 16));
                textoLineaDeTiempo.setMargin(new Insets(10, 10, 10, 10));
            
                // Agregar el JTextArea a un JScrollPane para permitir desplazamiento
                JScrollPane scrollPane = new JScrollPane(textoLineaDeTiempo);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            
                // Agregar el JScrollPane al panel principal
                pantallaLineaDeTiempo.add(scrollPane);
            
                // Botón para volver al menú principal
                JButton backButton = new JButton("Volver");
                backButton.addActionListener(e -> cardLayout.show(panelCards, "PantallaBienvenida"));
                backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                pantallaLineaDeTiempo.add(backButton);
            
                // Agregar el panel de la línea de tiempo a los panels de Cards
                panelCards.add(pantallaLineaDeTiempo, "LineaDeTiempo");
                cardLayout.show(panelCards, "LineaDeTiempo");
            }
            
        
        private void mostrarBuscador() {
                JPanel pantallaBuscador = new JPanel();
                pantallaBuscador.setLayout(new BoxLayout(pantallaBuscador, BoxLayout.Y_AXIS));

                JLabel etiquetaInstruccion = new JLabel(
                                "Ingrese una palabra clave para buscar (Ejemplo: Eniac, Java, iPhone):");
                JTextField campoBusqueda = new JTextField(20);
                JButton botonBuscar = new JButton("Buscar");
                JLabel etiquetaResultado = new JLabel("");
                etiquetaResultado.setPreferredSize(new Dimension(500, 100));
                etiquetaResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
                JLabel etiquetaAvances = new JLabel("");
                etiquetaAvances.setPreferredSize(new Dimension(500, 1000));
                etiquetaAvances.setAlignmentX(Component.CENTER_ALIGNMENT);

                botonBuscar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String terminoBusqueda = campoBusqueda.getText().toLowerCase().trim();
                                boolean encontrado = false;

                                // Buscar el término en la lista de palabras clave
                                for (int i = 0; i < palabrasClave.length; i++) {
                                        if (palabrasClave[i].toLowerCase().contains(terminoBusqueda)) {
                                                etiquetaResultado.setText("<html><b>" + palabrasClave[i] + ":</b> "
                                                                + descripciones[i]
                                                                + "<br><b>Año:</b> " + años[i] + "</html>");
                                                etiquetaResultado.setForeground(Color.BLACK);
                                                etiquetaAvances.setText(
                                                                "<html><b>Avance importante:</b> Este evento marcó un antes y un después en la informática moderna.</html>");
                                                etiquetaAvances.setForeground(Color.RED);
                                                encontrado = true;
                                                break;
                                        }
                                }

                                if (!encontrado) {
                                        etiquetaResultado.setText("No se encontró información sobre: <b>"
                                                        + terminoBusqueda + "</b>");
                                        etiquetaResultado.setForeground(Color.BLACK);
                                        etiquetaAvances.setText("");
                                }
                        }
                });

                pantallaBuscador.add(etiquetaInstruccion);
                pantallaBuscador.add(campoBusqueda);
                pantallaBuscador.add(botonBuscar);
                pantallaBuscador.add(etiquetaResultado);
                pantallaBuscador.add(etiquetaAvances);

                // Agregar el panel de buscador al panel de Cards
                panelCards.add(pantallaBuscador, "Buscador");
                cardLayout.show(panelCards, "Buscador");
        }

        public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> {
                        aplicacion app = new aplicacion();
                        app.setVisible(true);
                });
        }
}