public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        //Минимальная температура клиента
        float minTemp = 32.0f;
        //Максимальная температура клиента
        float maxTemp = 40.0f;
        //Создаем массив с температурами пациентов
        float[] temperaturePatients = new float[patientsCount];
        for (int i = 0; i < temperaturePatients.length; i++) {
            //Генерируем числа и записываем их в массив
            temperaturePatients[i] = (float) Math.round(((Math.random() * ((maxTemp - minTemp))) + minTemp)*10)/10f;
        }
        return new float[patientsCount];
    }

    public static String getReport(float[] temperatureData) {
        String tempPatients = "";
        float sumTemp = 0.0f;
        int healthyPatient = 0;
        for (int i = 0; i < temperatureData.length; i++) {
            tempPatients += temperatureData[i] + " ";
            sumTemp += temperatureData[i];
            if(temperatureData[i] > 36.1 && temperatureData[i] < 37.0){
                healthyPatient++;
            }
        }
        float averageTemp = Math.round((sumTemp/temperatureData.length)*10)/10f;



        String report =
            "Температуры пациентов: " + tempPatients.trim() +
                "\nСредняя температура: " + averageTemp +
                "\nКоличество здоровых: " + healthyPatient;

        return report;
    }
}