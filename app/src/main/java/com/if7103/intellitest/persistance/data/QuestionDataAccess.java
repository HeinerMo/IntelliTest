package com.if7103.intellitest.persistance.data;

import com.if7103.intellitest.domain.entity.Question;
import com.if7103.intellitest.domain.entity.QuestionOption;

import java.util.ArrayList;

public class QuestionDataAccess {


    private ArrayList<Question> questions;
    private static QuestionDataAccess questionDataAccess;

    private QuestionDataAccess() {
        questions = new ArrayList<>();
        //ESPACIAL
        questions.add(new Question("¿Te sientes cómodo navegando por nuevos lugares sin la ayuda de mapas?"));
        questions.add(new Question("¿Eres capaz de visualizar y manipular objetos en tu mente de manera precisa?"));
        questions.add(new Question("¿Tienes facilidad para resolver rompecabezas visuales?"));
        //MUSICAL
        questions.add(new Question("¿Tienes la capacidad de distinguir diferentes tonos musicales con facilidad?"));
        questions.add(new Question("¿Eres capaz de reconocer diferentes ritmos de música?"));
        questions.add(new Question("¿Tienes la capacidad de componer música?"));
        //LINGUISTICA
        questions.add(new Question("¿Disfrutas leyendo libros, revistas o periódicos?"));
        questions.add(new Question("¿Tienes facilidad para expresar tus ideas?"));
        questions.add(new Question("¿Tienes un amplio vocabulario y puedes utilizar palabras complejas con facilidad?"));
        //LOGICA
        questions.add(new Question("¿Disfrutas resolviendo problemas matemáticos y lógicos?"));
        questions.add(new Question("¿Eres capaz de identificar patrones y relaciones entre números?"));
        questions.add(new Question("¿Tienes habilidades para encontrar soluciones a través de la deducción y el análisis?"));
        //CORPORAL
        questions.add(new Question("¿Tienes habilidades destacadas en deportes?"));
        questions.add(new Question("¿Tienes facilidad para controlar tus movimientos y postura?"));
        questions.add(new Question("¿Disfrutas realizar actividades que involucren el uso de tus manos?"));
        //INTRAPERSONAL
        questions.add(new Question("¿Tienes una buena comprensión de tus propias emociones y motivaciones?"));
        questions.add(new Question("¿Eres consciente de tus propios pensamientos?"));
        questions.add(new Question("¿Disfrutas de actividades que fomentan la autorreflexión?"));
        //INTERPERSONAL
        questions.add(new Question("¿Tienes facilidad para empatizar con las emociones de los demás?"));
        questions.add(new Question("¿Eres capaz de mantener relaciones interpersonales sólidas?"));
        questions.add(new Question("¿Disfrutas de trabajar en equipo y tienes habilidades para resolver conflictos?"));
        //NATURALISTA
        questions.add(new Question("¿Tienes una gran afinidad con la naturaleza?"));
        questions.add(new Question("¿Tienes la capacidad de reconocer detalles específicos de plantas o animales?"));
        questions.add(new Question("¿Eres capaz de identificar sistemas, como el clima, los ecosistemas o los ciclos naturales?"));
        //EXISTENCIAL
        questions.add(new Question("¿Tienes un fuerte interés en Questions filosóficas y existenciales?"));
        questions.add(new Question("¿Te cuestionas regularmente sobre tu propio propósito?"));
        questions.add(new Question("¿Eres capaz de encontrar un sentido incluso en situaciones difíciles?"));
        //CREATIVA
        questions.add(new Question("¿Tienes facilidad para generar ideas nuevas y originales?"));
        questions.add(new Question("¿Disfrutas de actividades, como la pintura, la música o el diseño?"));
        questions.add(new Question("¿Eres capaz de encontrar soluciones innovadoras y creativas?"));
        //EMOCIONAL
        questions.add(new Question("¿Tienes la capacidad de comprender tus propias emociones de manera precisa?"));
        questions.add(new Question("¿Eres capaz de manejar tus emociones de manera saludable?"));
        questions.add(new Question("¿Tienes habilidades para reconocer las emociones de los demás y responder empáticamente?"));
        //COLABORATIVA
        questions.add(new Question("¿Eres capaz de trabajar efectivamente en equipo, aportando ideas y colaborando con los demás?"));
        questions.add(new Question("¿Tienes habilidades para comunicarte de manera clara y respetuosa?"));
        questions.add(new Question("¿Disfrutas de la oportunidad de aprender de los demás?"));

        int[] basicOption = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int shift = 0;
        for (Question q : questions) {
            QuestionOption[] options = new QuestionOption[3];
            options[0] = new QuestionOption("Mucho", shiftArray(basicOption, shift));
            shift++;
            options[1] = new QuestionOption("Poco", shiftArray(basicOption, shift));
            shift++;
            options[2] = new QuestionOption("Nada", shiftArray(basicOption, shift));
            shift++;
            q.setOptions(options);
        }


    }

    public static QuestionDataAccess getInstance() {
        if (questionDataAccess == null) {
            questionDataAccess = new QuestionDataAccess();
        }
        return questionDataAccess;
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public void clearOptions() {
        for (Question question : questions) {
            question.setResponse("");
        }
    }

    public int[] shiftArray(int[] arr, int shiftBy) {
        int length = arr.length;
        int[] shiftedArray = new int[length];
        // Calculate the effective shift amount within the array length
        int shiftAmount = shiftBy % length;

        // Shift the array elements
        for (int i = 0; i < length; i++) {
            int newIndex = (i + shiftAmount) % length;
            shiftedArray[newIndex] = arr[i];
        }
        return shiftedArray;
    }
}
