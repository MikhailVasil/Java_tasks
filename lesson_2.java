// Дана строка sql-запроса "select * from students where ". Сформируйте 
// часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации 
// приведены ниже в виде json-строки.
// where name = 'Ivanov' AND country = 'Russia' AND city = 'Moscow' 
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", 
// "city":"Moscow", "age":"null"}

// Дополнительные задания

// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова",
// "оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст 
// строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// *Сравнить время выполнения замены символа "а" на "А" любой строки 
// содержащей >1000 символов средствами String и StringBuilder.

import java.util.Arrays;

public class lesson_2 {
    public static void main(String[] args) {
        String str = "select * from students where ";
        System.out.println(str);  
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        // select * from students where name = 'Ivanov' AND country = 'Russia' AND city = 'Moscow'
        String json1 = json.replace("{", "").replace("\"", "").replace("}", "");
        System.out.println(json1);
        String [] array = json1.split(", ");
        System.out.println(Arrays.toString(array));
        StringBuilder result = new StringBuilder(str);

        for (int i = 0; i < array.length; i++) {
            String[] arrData = array[i].split(":");
            if(arrData[1].equals("null") == false) {
                if (i != 0) {
                    result.append(" AND ");
                    result.append(arrData[0]);
                    result.append(" = \'");
                    result.append(arrData[1]);
                    result.append("\'");                    
                } else {
                    result.append(arrData[0]);
                    result.append(" = \'");
                    result.append(arrData[1]);
                    result.append("\'");                    
                }
            }
            
        }
        System.out.println(result);
    }
}