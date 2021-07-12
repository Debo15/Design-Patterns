package Creational;


enum LAYOUTT {WINDOWS, WEB}

//-------------------------//

interface CheckBox {
    void render();
}
class WebCheckBox implements CheckBox{

    @Override
    public void render() {
        System.out.println("this is a web CheckBox.");
    }
}

class WindowsCheckBox implements CheckBox{

    @Override
    public void render() {
        System.out.println("this is a windows CheckBox.");
    }
}

//-------------------------//

interface EditBox{
    void render();
}
class WindowsEditBox implements EditBox{
    @Override
    public void render(){
        System.out.println("this is a Windows Edit Box.");
    }
}
class WebEditBox implements EditBox{
    @Override
    public void render() {
        System.out.println("this is a Web edit box.");
    }
}

//-------------------------//

interface AbstractFactory {
    CheckBox createCheckBox();
    EditBox createEditBox();
}

class WindowsCreator implements AbstractFactory{
    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }

    @Override
    public EditBox createEditBox() {
        return new WindowsEditBox();
    }
}

class WebCreator implements AbstractFactory{
    @Override
    public CheckBox createCheckBox() {
        return new WebCheckBox();
    }

    @Override
    public EditBox createEditBox() {
        return new WebEditBox();
    }
}

//-----------------------------//

class GUIGenerator{
    public AbstractFactory factory;
    GUIGenerator(LAYOUTT type) throws Exception {
        switch (type){
            case WINDOWS:
                factory = new WindowsCreator();
                break;
            case WEB:
                factory = new WebCreator();
                break;
            default:
                throw new Exception("unknown layout.");
        }
    }
}

class AbstractFactoryDemo {
    public static void main(String[] args) throws Exception {
        GUIGenerator generator = new GUIGenerator(LAYOUTT.WINDOWS);
        EditBox a = generator.factory.createEditBox();
        CheckBox b = generator.factory.createCheckBox();
        a.render();
        b.render();
    }
}