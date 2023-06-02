package Main;


public class Cuestionario {

	private Pregunta[] preguntas;
	private Inteligencia[] inteligencias;
	
	public Cuestionario() {
		super();
		this.preguntas = new Pregunta[36];
		this.inteligencias = new Inteligencia[12];
		crearInteligencias();
		crearCustionario();
		unirPreguntaInteligencia();
	}
	
	public void crearInteligencias() {
		this.inteligencias[0]=new Inteligencia("Espacial");
		this.inteligencias[1]=new Inteligencia("Musical");
		this.inteligencias[2]=new Inteligencia("lingüísticoVerbal");
		this.inteligencias[3]=new Inteligencia("lógicoMatemática");
		this.inteligencias[4]=new Inteligencia("corporalCinestésica");
		this.inteligencias[5]=new Inteligencia("Intrapersonal:");
		this.inteligencias[6]=new Inteligencia("Interpersonal");
		this.inteligencias[7]=new Inteligencia("Naturalista");
		this.inteligencias[8]=new Inteligencia("Existencial");
		this.inteligencias[9]=new Inteligencia("Creativa");
		this.inteligencias[10]=new Inteligencia("Emocional");
		this.inteligencias[11]=new Inteligencia("Colaborativa");
	}
	
	public void crearCustionario() {
		//ESPACIAL
		this.preguntas[0]=new Pregunta("¿Te sientes cómodo navegando por nuevos lugares sin la ayuda de mapas?");
		this.preguntas[1]=new Pregunta("¿Eres capaz de visualizar y manipular objetos en tu mente de manera precisa?");
		this.preguntas[2]=new Pregunta("¿Tienes facilidad para resolver rompecabezas visuales?");
		//MUSICAL
		this.preguntas[3]=new Pregunta("¿Tienes la capacidad de distinguir diferentes tonos musicales con facilidad?");
		this.preguntas[4]=new Pregunta("¿Eres capaz de reconocer diferentes ritmos de música?");
		this.preguntas[5]=new Pregunta("¿Tienes la capacidad de componer música?");
		//LINGUISTICA
		this.preguntas[6]=new Pregunta("¿Disfrutas leyendo libros, revistas o periódicos?");
		this.preguntas[7]=new Pregunta("¿Tienes facilidad para expresar tus ideas?");
		this.preguntas[8]=new Pregunta("¿Tienes un amplio vocabulario y puedes utilizar palabras complejas con facilidad?");
		//LOGICA
		this.preguntas[9]=new Pregunta("¿Disfrutas resolviendo problemas matemáticos y lógicos?");
		this.preguntas[10]=new Pregunta("¿Eres capaz de identificar patrones y relaciones entre números?");
		this.preguntas[11]=new Pregunta("¿Tienes habilidades para encontrar soluciones a través de la deducción y el análisis?");
		//CORPORAL
		this.preguntas[12]=new Pregunta("¿Tienes habilidades destacadas en deportes?");
		this.preguntas[13]=new Pregunta("¿Tienes facilidad para controlar tus movimientos y postura?");
		this.preguntas[14]=new Pregunta("¿Disfrutas realizar actividades que involucren el uso de tus manos?");
		//INTRAPERSONAL
		this.preguntas[15]=new Pregunta("¿Tienes una buena comprensión de tus propias emociones y motivaciones?");
		this.preguntas[16]=new Pregunta("¿Eres consciente de tus propios pensamientos?");
		this.preguntas[17]=new Pregunta("¿Disfrutas de actividades que fomentan la autorreflexión?");
		//INTERPERSONAL
		this.preguntas[18]=new Pregunta("¿Tienes facilidad para empatizar con las emociones de los demás?");
		this.preguntas[19]=new Pregunta("¿Eres capaz de mantener relaciones interpersonales sólidas?");
		this.preguntas[20]=new Pregunta("¿Disfrutas de trabajar en equipo y tienes habilidades para resolver conflictos?");
	    //NATURALISTA
		this.preguntas[21]=new Pregunta("¿Tienes una gran afinidad con la naturaleza?");
		this.preguntas[22]=new Pregunta("¿Tienes la capacidad de reconocer detalles específicos de plantas o animales?");
		this.preguntas[23]=new Pregunta("¿Eres capaz de identificar sistemas, como el clima, los ecosistemas o los ciclos naturales?");
		//EXISTENCIAL
		this.preguntas[24]=new Pregunta("¿Tienes un fuerte interés en preguntas filosóficas y existenciales?");
		this.preguntas[25]=new Pregunta("¿Te cuestionas regularmente sobre tu propio propósito?");
		this.preguntas[26]=new Pregunta("¿Eres capaz de encontrar un sentido incluso en situaciones difíciles?");
		//CREATIVA
		this.preguntas[27]=new Pregunta("¿Tienes facilidad para generar ideas nuevas y originales?");
		this.preguntas[28]=new Pregunta("¿Disfrutas de actividades, como la pintura, la música o el diseño?");
		this.preguntas[29]=new Pregunta("¿Eres capaz de encontrar soluciones innovadoras y creativas?");
		//EMOCIONAL
		this.preguntas[30]=new Pregunta("¿Tienes la capacidad de comprender tus propias emociones de manera precisa?");
		this.preguntas[31]=new Pregunta("¿Eres capaz de manejar tus emociones de manera saludable?");
		this.preguntas[32]=new Pregunta("¿Tienes habilidades para reconocer las emociones de los demás y responder empáticamente?");
		//COLABORATIVA
		this.preguntas[33]=new Pregunta("¿Eres capaz de trabajar efectivamente en equipo, aportando ideas y colaborando con los demás?");
		this.preguntas[34]=new Pregunta("¿Tienes habilidades para comunicarte de manera clara y respetuosa?");
		this.preguntas[35]=new Pregunta("¿Disfrutas de la oportunidad de aprender de los demás?");
	}
	
	public void unirPreguntaInteligencia() {
		int cont = 0;
		for (int i = 0; i < preguntas.length; i++) {
			this.preguntas[i].setTipoInteligencia(this.inteligencias[cont]);
			if((i+1) % 3 == 0) {
				cont++;
			}	
		}
	}

	public Pregunta[] getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Pregunta[] preguntas) {
		this.preguntas = preguntas;
	}
	
	
}
