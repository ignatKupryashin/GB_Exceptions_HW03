import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.HashSet;

public class Parser {
    private String[] inputData;
    private Note currentNote;
    private int noteLength;


    public Parser(String inputString) {
        this.inputData = inputString.split("\\s+");
        this.currentNote = new Note();
        this.noteLength = 6;
    }


    /**
     * Парсит данные из строки в Note
     * @throws NoteLengthException
     */
    public void parse() throws NoteLengthException{
        if (inputData.length != this.noteLength){
            throw new NoteLengthException("Введено некорректное колличество параметров", inputData.length, this.noteLength);
        }
        else {
           fillTheNote();
           try {
               checkTheNote();
           }
           catch (NoteNotFullException e){
               System.out.printf("Введены не все данные. Не хватает:\n%s", e.getMessage());
           }

        }
    }

    /**
     * Наполняет заметку валидными данными
     */
    private void fillTheNote(){
        for (String data:inputData
        ) {
            if (checkPhone(data) && currentNote.getPhone() == 0){
                currentNote.setPhone(Long.parseLong(data));
            } else if (checkDate(data) && currentNote.getBirthday() == null) {
                currentNote.setBirthday(data);
            } else if (checkSex(data) && currentNote.getSex() == null) {
                currentNote.setSex(data);
            } else if (currentNote.getLastName() == null) {
                currentNote.setLastName(data);
            } else if (currentNote.getName() == null) {
                currentNote.setName(data);
            } else if (currentNote.getPatronymic() == null) {
                currentNote.setPatronymic(data);
            }
        }
    }

    /**
     * Проверяет полноту заполнения Note
     * @throws NoteLengthException
     */
    private void checkTheNote() throws NoteLengthException{
        StringBuilder sb = new StringBuilder();
        if (currentNote.getPhone() == 0){
            sb.append("Телефон\n");
        }
        if (currentNote.getBirthday() == null){
            sb.append("День рождения\n");
        }
        if (currentNote.getSex() == null){
            sb.append("Пол\n");
        }

        String message = sb.toString();
        if (!message.equals("")){
            throw new NoteNotFullException(message);
        }

    }



    /**
     * Метод проверки соответствия для поля "Телефон"
     * @param data входящая строка
     */
    private boolean checkPhone(String data){
        long parsedNumber;
        try {
            parsedNumber = Long.parseLong(data);
        }
        catch (NumberFormatException e){
            return false;
        }

        return parsedNumber > Long.parseLong("9999999999")
                && parsedNumber < Long.parseLong("1000000000000");
    }

    /**
     * Метод проверки соответствия для поля  "Дата рождения"
     * @param data входящая строка
     */
    private boolean checkDate(String data){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate.parse(data, format);
            return true;
        }
        catch (DateTimeParseException e){
            return false;
        }
    }

    /**
     * Метод проверки соответствия для поля "Пол"
     * @param data входящая строка
     */
    private boolean checkSex(String data){
        if (data.equals("f")||data.equals("m")){
            return true;
        }
        else {
            return false;
        }
    }

    public Note getCurrentNote() {
        return currentNote;
    }
}
