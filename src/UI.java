import java.io.IOException;
import java.util.Scanner;

public class UI {

    Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public String getString(){
        System.out.println("Введите <Фамилия> <Имя> <Отчество> <дата рождения> <номер телефона> <пол>\n" +
                "Вводить можно в произвольном порядке\n" +
                "Фамилия Имя Отчество должны быть введены подряд и именно в такой последовательности\n" +
                "Формат даты рождения: dd.mm.yyyy\n" +
                "формат номера телефона: 8XXXXXXXXXX\n" +
                "Формат пола: либо m либо f\n" +
                "Ведите данные:");
        return scanner.nextLine();
    }

    public void run()  {
        Parser parser = new Parser(getString());
        try {
            parser.parse();
            try {
                Writer writer = new Writer(parser.getCurrentNote().getLastName() + ".txt");
                writer.write(parser.getCurrentNote().toString());
            }
            catch (IOException e){
                System.out.printf("Что то не так с записью файла. %s", e.getMessage());
            }
        }
        catch (NoteLengthException e){
            System.out.printf("%s\nВведено: %d параметров\nНеобходимо %d параметров", e.getMessage(), e.getLength(), e.getNeededLength());
        }

    }
}
