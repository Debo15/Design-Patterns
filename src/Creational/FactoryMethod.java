package Creational;


interface Button{
    void onClick();
    void render();
}
class WebButton implements Button{

    @Override
    public void onClick() {
        System.out.println("you clicked a web Button.");
    }

    @Override
    public void render() {
        System.out.println("this is a web Button.");
    }
}

class WindowsButton implements Button{
    @Override
    public void onClick() {
        System.out.println("you clicked a windows Button.");
    }

    @Override
    public void render() {
        System.out.println("this is a windows Button.");
    }
}

enum LAYOUT{WINDOWS, WEB}

class ButtonGenerator {

    public static Button createButton(LAYOUT TYPE) throws Exception {
        switch (TYPE) {
            case WINDOWS:
                return new WindowsButton();
            case WEB:
                return new WebButton();
            default:
                throw new Exception("unknown button layout");
        }
    }
}

class FactoryMethodDemo {
    public static void main(String[] args) throws Exception {
        Button button = ButtonGenerator.createButton(LAYOUT.WEB);
        button.render();
        button.onClick();
    }
}
