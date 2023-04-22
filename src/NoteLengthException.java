
public class NoteLengthException extends RuntimeException{
    private int length;
    private int neededLength;

    /**
     * Исключение, указывающее на слишком малое колличество введенных аргументов
     * @param message сообщение пользователю
     * @param length введенная длинна
     * @param neededLength необходимая длинна
     */
    public NoteLengthException(String message, int length, int neededLength) {
        super(message);
        this.length = length;
        this.neededLength = neededLength;
    }

    public int getLength() {
        return length;
    }

    public int getNeededLength(){
        return neededLength;
    }

}
