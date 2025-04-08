import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

//implementing ActionListener interface
public class Calculator implements ActionListener {
    //Creating variables for our calculations
    int number=0;
    int answer = 0;
    boolean andOperation=false;
    boolean orOperation=false;
    boolean xorOperation=false;
    boolean LeftOperation=false;
    boolean RightOperation=false;
    int calculation;
    boolean calculate = false;
    JFrame frame;
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JRadioButton hexadecimalRadioButton = new JRadioButton("Hexadecimal");
    JRadioButton decimalRadioButton = new JRadioButton("Decimal");
    JRadioButton binaryRadioButton = new JRadioButton("Binary");
    JLabel hexalabel = new JLabel("0");
    JLabel decimallabel = new JLabel("0");
    JLabel binarylabel = new JLabel("0");
    JButton buttonA = new JButton("A");
    JButton buttonB = new JButton("B");
    JButton buttonC = new JButton("C");
    JButton buttonD = new JButton("D");
    JButton buttonE = new JButton("E");
    JButton buttonF = new JButton("F");
    JButton buttonZero = new JButton("0");
    JButton buttonOne = new JButton("1");
    JButton buttonTwo = new JButton("2");
    JButton buttonThree = new JButton("3");
    JButton buttonFour = new JButton("4");
    JButton buttonFive = new JButton("5");
    JButton buttonSix = new JButton("6");
    JButton buttonSeven = new JButton("7");
    JButton buttonEight = new JButton("8");
    JButton buttonNine = new JButton("9");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("C");
    JButton buttonEqual = new JButton("=");
    JButton buttonMul = new JButton("x");
    JButton buttonDiv = new JButton("/");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonNot = new JButton("NOT");
    JButton buttonLeft = new JButton("<<");
    JButton buttonRight = new JButton(">>");
    JButton buttonAnd = new JButton("And");
    JButton buttonOr = new JButton("Or");
    JButton buttonXor = new JButton("XOR");
    int SelectedRadioButton = 1;

    Calculator() { //constructor defines
        prepareGUI();
        addComponents();
        addActionEvent();
    }

    public void prepareGUI() { // prepares Gui
        frame = new JFrame();
        frame.setTitle("Programmer Calculator");
        frame.setSize(700, 700);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponents() { // adds components into Gui
        label.setBounds(400, 140, 270, 50);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setForeground(Color.black);
        frame.add(label);


        textField.setBounds(400, 175, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        hexadecimalRadioButton.setBounds(90, 50, 120, 20);
        hexadecimalRadioButton.setSelected(true);
        hexadecimalRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        hexadecimalRadioButton.setBackground(Color.white);
        frame.add(hexadecimalRadioButton);

        decimalRadioButton.setBounds(90, 100, 80, 20);
        decimalRadioButton.setSelected(false);
        decimalRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        decimalRadioButton.setBackground(Color.white);
        frame.add(decimalRadioButton);

        binaryRadioButton.setBounds(90,150,70,20);
        binaryRadioButton.setSelected(false);
        binaryRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        binaryRadioButton.setBackground(Color.white);
        frame.add(binaryRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(hexadecimalRadioButton);
        buttonGroup.add(decimalRadioButton);
        buttonGroup.add(binaryRadioButton);

        buttonSeven.setBounds(210, 360, 100, 50);
        buttonSeven.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSeven);

        buttonEight.setBounds(330, 360, 100, 50);
        buttonEight.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonEight);

        buttonNine.setBounds(450, 360, 100, 50);
        buttonNine.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonNine);

        buttonFour.setBounds(210, 430, 100, 50);
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFour);

        buttonFive.setBounds(330, 430, 100, 50);
        buttonFive.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFive);

        buttonSix.setBounds(450, 430, 100, 50);
        buttonSix.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSix);

        buttonOne.setBounds(210, 500, 100, 50);
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonOne);

        buttonTwo.setBounds(330, 500, 100, 50);
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonTwo);

        buttonThree.setBounds(450, 500, 100, 50);
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonThree);


        buttonZero.setBounds(330, 570, 100, 50);
        buttonZero.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonZero);

        buttonEqual.setBounds(570, 570, 100, 50);
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEqual.setBackground(new Color(239, 188, 2));
        frame.add(buttonEqual);

        buttonDiv.setBounds(570, 500, 100, 50);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDiv.setBackground(new Color(239, 188, 2));
        frame.add(buttonDiv);

        buttonMul.setBounds(570, 430, 100, 50);
        buttonMul.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMul.setBackground(new Color(239, 188, 2));
        frame.add(buttonMul);

        buttonMinus.setBounds(570, 360, 100, 50);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMinus.setBackground(new Color(239, 188, 2));
        frame.add(buttonMinus);

        buttonPlus.setBounds(570, 290, 100, 50);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPlus.setBackground(new Color(239, 188, 2));
        frame.add(buttonPlus);

        buttonClear.setBounds(570, 220, 100, 50);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 12));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        frame.add(buttonClear);

        buttonA.setBounds(90,220,100,50);
        buttonA.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonA);

        buttonB.setBounds(90,290,100,50);
        buttonB.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonB);

        buttonC.setBounds(90,360,100,50);
        buttonC.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonC);

        buttonD.setBounds(90,430,100,50);
        buttonD.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonD);

        buttonE.setBounds(90,500,100,50);
        buttonE.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonE);

        buttonF.setBounds(90,570,100,50);
        buttonF.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonF);

        buttonNot.setBounds(210,220,100,50);
        buttonNot.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonNot);

        buttonAnd.setBounds(210,290,100,50);
        buttonAnd.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonAnd);

        buttonLeft.setBounds(330,220,100,50);
        buttonLeft.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonLeft);

        buttonOr.setBounds(330,290,100,50);
        buttonOr.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonOr);

        buttonRight.setBounds(450,220,100,50);
        buttonRight.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonRight);

        buttonXor.setBounds(450,290,100,50);
        buttonXor.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(buttonXor);

        hexalabel.setBounds(210,45 ,200,30);
        hexalabel.setFont(new Font("Arial",Font.BOLD,14));
        frame.add(hexalabel);

        decimallabel.setBounds(175,95 ,200,30);
        decimallabel.setFont(new Font("Arial",Font.BOLD,14));
        frame.add(decimallabel);

        binarylabel.setBounds(165,145 ,400,30);
        binarylabel.setFont(new Font("Arial",Font.BOLD,14));
        frame.add(binarylabel);

    }

    public void addActionEvent() {
        //Registering ActionListener to buttons
        hexadecimalRadioButton.addActionListener(this);
        decimalRadioButton.addActionListener(this);
        binaryRadioButton.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonZero.addActionListener(this);
        buttonDot.addActionListener(this);
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);
        buttonD.addActionListener(this);
        buttonE.addActionListener(this);
        buttonF.addActionListener(this);
        buttonNot.addActionListener(this);
        buttonAnd.addActionListener(this);
        buttonOr.addActionListener(this);
        buttonXor.addActionListener(this);
        buttonLeft.addActionListener(this);
        buttonRight.addActionListener(this);


    }
    //Overriding actionPerformed() method
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == hexadecimalRadioButton) {
            if(SelectedRadioButton!=1&& !hexalabel.getText().equals("0")){//Checks is this radio button selected currently.
                //if last chosen radio button was this one changes text field to what writes near the 'hexalabel' label's
                textField.setText(hexalabel.getText());//if last chosen radio button was not this one changes text field.
            }
            SelectedRadioButton=1;
            HexadecimalSelected();//Calling HexadecimalSelected() function for enable or disable items
            label.setText("");
        } else if (source == decimalRadioButton) {
            if(SelectedRadioButton!=2&& !decimallabel.getText().equals("0")){ //Checks is this radio button selected currently.
                //if last chosen radio button was this one changes text field to what writes near the 'decimallabel' label's
                textField.setText(decimallabel.getText());
            }
            SelectedRadioButton=2;
            DecimalSelected();//Calling DecimalSelected() function for enable or disable items
            label.setText("");
        } else if (source ==binaryRadioButton ){
            if(SelectedRadioButton!=3&& !binarylabel.getText().equals("0")){//Checks is this radio button selected currently.
                //if last chosen radio button was this one changes text field to what writes near the 'binarylabel' label's
                textField.setText(binarylabel.getText());
            }
            SelectedRadioButton=3;
            BinarySelected();  //Calling BinarySelected() function for enable or disable items
            label.setText("");
        } else if (source == buttonClear) {
            //Clearing texts of labels, text field, reseting all variables.
            label.setText("");
            textField.setText("");
            hexalabel.setText("0");
            decimallabel.setText("0");
            binarylabel.setText("0");
            answer = 0;
            number=0;
        } else if (source == buttonZero) {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (source == buttonOne) {
            textField.setText(textField.getText() + "1");
        } else if (source == buttonTwo) {
            textField.setText(textField.getText() + "2");
        } else if (source == buttonThree) {
            textField.setText(textField.getText() + "3");
        } else if (source == buttonFour) {
            textField.setText(textField.getText() + "4");
        } else if (source == buttonFive) {
            textField.setText(textField.getText() + "5");
        } else if (source == buttonSix) {
            textField.setText(textField.getText() + "6");
        } else if (source == buttonSeven) {
            textField.setText(textField.getText() + "7");
        } else if (source == buttonEight) {
            textField.setText(textField.getText() + "8");
        } else if (source == buttonNine) {
            textField.setText(textField.getText() + "9");
        }  else if (source ==buttonA){
            textField.setText(textField.getText()+"a");
        } else if (source ==buttonB){
            textField.setText(textField.getText()+"b");
        } else if (source ==buttonC){
            textField.setText(textField.getText()+"c");
        } else if (source ==buttonD){
            textField.setText(textField.getText()+"d");
        } else if (source ==buttonE){
            textField.setText(textField.getText()+"e");
        } else if (source ==buttonF){
            textField.setText(textField.getText()+"f");
        }else if (source == buttonDot) {
            if (textField.getText().contains(".")) {
                return;
            } else {
                textField.setText(textField.getText() + ".");
            }

        }else if (source==buttonNot){ //Setting functionality for Not(NOT) button
            if(hexadecimalRadioButton.isSelected()){ // if hexadecimal radio button selected:
                answer = Integer.parseInt(textField.getText(),16)*-1-1;
                textField.setText(Integer.toHexString(answer));
                hexalabel.setText(Integer.toHexString(answer));
                decimallabel.setText(Integer.toString(answer));
                binarylabel.setText(Integer.toBinaryString(answer));

            }
            else if(binaryRadioButton.isSelected()){ // if binary button selected
                BigInteger bigInteger = new BigInteger(Integer.toBinaryString(Integer.parseInt(textField.getText(),2)*-1-1));
                answer = Integer.parseInt(textField.getText(),2)*-1-1;
                textField.setText(bigInteger+"");
                hexalabel.setText(Integer.toHexString(answer));
                decimallabel.setText(Integer.toString(answer));
                binarylabel.setText(bigInteger+"");
            }
            else{
                answer=Integer.parseInt(textField.getText())*-1-1;
                textField.setText(Integer.toString(answer));
                hexalabel.setText(Integer.toHexString(answer));
                decimallabel.setText(Integer.toString(answer));
                binarylabel.setText(Integer.toBinaryString(answer));
            }
        }
        else if (source == buttonPlus) { //Setting functionality for Plus(+) button
            String str = textField.getText();
            setNumber(); // to determine first number which user entered calling setNumber() function.
            textField.setText("");
            label.setText(str + "+");
            calculation = 1;
            calculate= true;
        } else if (source == buttonMinus) { //Setting functionality for Minus(-) button
            String str = textField.getText();
            setNumber(); // to determine first number which user entered calling setNumber() function.
            textField.setText("");
            label.setText(str + "-");
            calculation = 2;
            calculate= true;
        } else if (source == buttonMul) { //Setting functionality for Mul(X) button
            String str = textField.getText();
            setNumber(); // to determine first number which user entered calling setNumber() function.
            textField.setText("");
            label.setText(str + "X");
            calculation = 3;
            calculate= true;
        } else if (source == buttonDiv) { //Setting functionality for Div(/) button
            String str = textField.getText();
            setNumber(); // to determine first number which user entered calling setNumber() function.
            textField.setText("");
            label.setText(str + "/");
            calculation = 4;
            calculate= true;
        }
         else if(source==buttonAnd){ //Setting functionality for And(And) button
             setNumber(); // to determine first number which user entered calling setNumber() function.
             label.setText(textField.getText()+"AND");
             textField.setText("");
             andOperation=true;
        }
         else if(source==buttonOr){ //Setting functionality for Or(Or) button
            setNumber(); // to determine first number which user entered calling setNumber() function.
            label.setText(textField.getText()+"OR");
            textField.setText("");
            orOperation=true;

        }
        else if(source==buttonXor){ //Setting functionality for Xor(XOR) button
            setNumber(); // to determine first number which user entered calling setNumber() function.
            label.setText(textField.getText()+"XOR");
            textField.setText("");
            xorOperation=true;

        }
        else if (source==buttonLeft){ //Setting functionality for Left(<<) button
           setNumber(); // to determine first number which user entered calling setNumber() function.
            label.setText(textField.getText()+"<<");
            textField.setText("");
            LeftOperation = true;

        }

        else if (source==buttonRight){ //Setting functionality for Right(>>) button
            setNumber(); // to determine first number which user entered calling setNumber() function.
            label.setText(textField.getText()+">>");
            textField.setText("");
            RightOperation = true;

        }
         else if (source == buttonEqual) { //Setting functionality for equal(=) button

            if(hexadecimalRadioButton.isSelected()&&calculate){

                switch (calculation) {
                    case 1: // Sum of numbers
                        answer = number + Integer.parseInt(textField.getText(),16);
                        textField.setText(Integer.toHexString(answer));
                        label.setText("");
                        hexalabel.setText(Integer.toHexString(answer));
                        decimallabel.setText(Integer.toString(answer));
                        binarylabel.setText(Integer.toBinaryString(answer));
                        break;
                    case 2: //Subtraction
                        answer = number - Integer.parseInt(textField.getText(),16);
                        textField.setText(Integer.toHexString(answer));
                        label.setText("");
                        hexalabel.setText(Integer.toHexString(answer));
                        decimallabel.setText(Integer.toString(answer));
                        binarylabel.setText(Integer.toBinaryString(answer));
                        break;
                    case 3: //Multiplication
                        answer = number * Integer.parseInt(textField.getText(),16);
                        textField.setText(Integer.toHexString(answer));
                        label.setText("");
                        hexalabel.setText(Integer.toHexString(answer));
                        decimallabel.setText(Integer.toString(answer));
                        binarylabel.setText(Integer.toBinaryString(answer));
                        break;
                    case 4: //Division
                        answer = number / Integer.parseInt(textField.getText(),16);
                        textField.setText(Integer.toHexString(answer));
                        label.setText("");
                        hexalabel.setText(Integer.toHexString(answer));
                        decimallabel.setText(Integer.toString(answer));
                        binarylabel.setText(Integer.toBinaryString(answer));
                        break;

                }
                calculate = false;
            }

            if(decimalRadioButton.isSelected()&&calculate){

            switch (calculation) {
                case 1: //Sum of number
                    answer = number + Integer.parseInt(textField.getText());
                    textField.setText(Integer.toString(answer));

                    hexalabel.setText(Integer.toHexString(answer));
                    decimallabel.setText(Integer.toString(answer));
                    binarylabel.setText(Integer.toBinaryString(answer));

                    label.setText("");
                    break;
                case 2: //Subtraction
                    answer = number - Integer.parseInt(textField.getText());
                    textField.setText(Integer.toString(answer));

                    hexalabel.setText(Integer.toHexString(answer));
                    decimallabel.setText(Integer.toString(answer));
                    binarylabel.setText(Integer.toBinaryString(answer));
                    label.setText("");
                    break;
                case 3://Multiplication
                    answer = number * Integer.parseInt(textField.getText());
                    textField.setText(Integer.toString(answer));

                    hexalabel.setText(Integer.toHexString(answer));
                    decimallabel.setText(Integer.toString(answer));
                    binarylabel.setText(Integer.toBinaryString(answer));
                    label.setText("");
                    break;
                case 4://division
                    answer = number / Integer.parseInt(textField.getText());
                    textField.setText(Integer.toString(answer));

                    hexalabel.setText(Integer.toHexString(answer));
                    decimallabel.setText(Integer.toString(answer));
                    binarylabel.setText(Integer.toBinaryString(answer));
                    label.setText("");
                    break;

            }
                calculate = false;
          }

            if(binaryRadioButton.isSelected()&&calculate){

                switch (calculation) {
                    case 1://Sum of numbers
                        answer = number + Integer.parseInt(textField.getText(),2);
                        textField.setText(Integer.toBinaryString(answer));

                        hexalabel.setText(Integer.toHexString(answer));
                        decimallabel.setText(Integer.toString(answer));
                        binarylabel.setText(Integer.toBinaryString(answer));

                        label.setText("");
                        break;
                    case 2://Subtraction
                        answer = number - Integer.parseInt(textField.getText(),2);
                        textField.setText(Integer.toBinaryString(answer));

                        hexalabel.setText(Integer.toHexString(answer));
                        decimallabel.setText(Integer.toString(answer));
                        binarylabel.setText(Integer.toBinaryString(answer));
                        label.setText("");
                        break;
                    case 3://Multiplication
                        answer = number * Integer.parseInt(textField.getText(),2);
                        textField.setText(Integer.toBinaryString(answer));

                        hexalabel.setText(Integer.toHexString(answer));
                        decimallabel.setText(Integer.toString(answer));
                        binarylabel.setText(Integer.toBinaryString(answer));
                        label.setText("");
                        break;
                    case 4://Division
                        answer = number / Integer.parseInt(textField.getText(),2);
                        textField.setText(Integer.toBinaryString(answer));

                        hexalabel.setText(Integer.toHexString(answer));
                        decimallabel.setText(Integer.toString(answer));
                        binarylabel.setText(Integer.toBinaryString(answer));
                        label.setText("");
                        break;

                }
                calculate = false;
            }

            if(andOperation){ // number(variable(first number)) AND(&) second number
                if(hexadecimalRadioButton.isSelected()){
                    answer = number & Integer.parseInt(textField.getText(),16);

                    hexalabel.setText(Integer.toString(answer,16));
                    binarylabel.setText(Integer.toString(answer,2));
                    decimallabel.setText(Integer.toString(answer,10));
                    label.setText("");
                    textField.setText(Integer.toString(answer,16));
                }
                else if(binaryRadioButton.isSelected()){
                    answer = number & Integer.parseInt(textField.getText(),2);

                    hexalabel.setText(Integer.toString(answer,16));
                    decimallabel.setText(Integer.toString(answer,10));
                    binarylabel.setText(Integer.toString(answer,2));
                    label.setText("");
                    textField.setText(Integer.toString(answer,2));
                }
                else{
                    answer = number & Integer.parseInt(textField.getText(),10);

                    hexalabel.setText(Integer.toString(answer,16));
                    decimallabel.setText(Integer.toString(answer,10));
                    binarylabel.setText(Integer.toString(answer,2));
                    label.setText("");
                    textField.setText(Integer.toString(answer,10));
                }

                andOperation=false;
            }
            if(orOperation){ // number(variable(first number)) OR(|) second number

                if(hexadecimalRadioButton.isSelected()){
                    answer = number | Integer.parseInt(textField.getText(),16);

                    hexalabel.setText(Integer.toString(answer,16));
                    decimallabel.setText(Integer.toString(answer,10));
                    binarylabel.setText(Integer.toString(answer,2));
                    label.setText("");
                    textField.setText(Integer.toString(answer,16));
                }
                else if(binaryRadioButton.isSelected()){
                    answer = number | Integer.parseInt(textField.getText(),2);

                    hexalabel.setText(Integer.toString(answer,16));
                    decimallabel.setText(Integer.toString(answer,10));
                    binarylabel.setText(Integer.toString(answer,2));
                    label.setText("");
                    textField.setText(Integer.toString(answer,2));
                }
                else{
                    answer = number | Integer.parseInt(textField.getText(),10);

                    hexalabel.setText(Integer.toString(answer,16));
                    decimallabel.setText(Integer.toString(answer,10));
                    binarylabel.setText(Integer.toString(answer,2));
                    label.setText("");
                    textField.setText(Integer.toString(answer,10));
                }


                orOperation=false;
            }

            if(xorOperation){ // number(variable(first number)) XOR(^) second number

                if(hexadecimalRadioButton.isSelected()){
                    answer = number ^ Integer.parseInt(textField.getText(),16);

                    hexalabel.setText(Integer.toString(answer,16));
                    decimallabel.setText(Integer.toString(answer,10));
                    binarylabel.setText(Integer.toString(answer,2));
                    label.setText("");
                    textField.setText(Integer.toString(answer,16));
                }
                else if(binaryRadioButton.isSelected()){
                    answer = number ^ Integer.parseInt(textField.getText(),2);

                    hexalabel.setText(Integer.toString(answer,16));
                    decimallabel.setText(Integer.toString(answer,10));
                    binarylabel.setText(Integer.toString(answer,2));
                    label.setText("");
                    textField.setText(Integer.toString(answer,2));
                }
                else{
                    answer = number ^ Integer.parseInt(textField.getText(),10);

                    hexalabel.setText(Integer.toString(answer,16));
                    decimallabel.setText(Integer.toString(answer,10));
                    binarylabel.setText(Integer.toString(answer,2));
                    label.setText("");
                    textField.setText(Integer.toString(answer,10));
                }
                xorOperation=false;
            }
            if(LeftOperation){ // number(variable(first number)) ShiftLeft(<<) second number

                if(hexadecimalRadioButton.isSelected()){
                    answer = number * (int)Math.pow(2,Integer.parseInt(textField.getText(),16));
                    textField.setText((Integer.toString(answer,16)));
                }
                else if(binaryRadioButton.isSelected()){
                    answer = number * (int)Math.pow(2,Integer.parseInt(textField.getText(),2));
                    textField.setText((Integer.toString(answer,2)));
                }
                else if(decimalRadioButton.isSelected()){
                    answer = number * (int)Math.pow(2,Integer.parseInt(textField.getText(),10));
                    textField.setText((Integer.toString(answer,10)));
                }

                hexalabel.setText(Integer.toString(answer,16));
                decimallabel.setText(Integer.toString(answer,10));
                binarylabel.setText(Integer.toString(answer,2));
                LeftOperation=false;
            }

            if(RightOperation){ // number(variable(first number)) ShiftRight (>>) second number

                if(hexadecimalRadioButton.isSelected()){
                    answer = number / (int)Math.pow(2,Integer.parseInt(textField.getText(),16));
                    textField.setText((Integer.toString(answer,16)));
                }
                else if(binaryRadioButton.isSelected()){
                    answer = number / (int)Math.pow(2,Integer.parseInt(textField.getText(),2));
                    textField.setText((Integer.toString(answer,2)));
                }
                else if(decimalRadioButton.isSelected()){
                    answer = number / (int)Math.pow(2,Integer.parseInt(textField.getText(),10));
                    textField.setText((Integer.toString(answer,10)));
                }

                hexalabel.setText(Integer.toString(answer,16));
                decimallabel.setText(Integer.toString(answer,10));
                binarylabel.setText(Integer.toString(answer,2));
                RightOperation=false;
            }
        }


    }
    public void setNumber(){ // to defines number(first number of calculation)
        if(hexadecimalRadioButton.isSelected()){
            number=Integer.parseInt(textField.getText(),16); //stores as a hexadecimal number
        }
        else if (binaryRadioButton.isSelected()){
            number=Integer.parseInt(textField.getText(),2); //stores as a binary number
        }
        else{
            number=Integer.parseInt(textField.getText(),10); // stores as a decimal number
        }
    }

    public void HexadecimalSelected() { //When clicked to the 'Hexadecimal' radio button:
        hexadecimalRadioButton.setEnabled(false);
        decimalRadioButton.setEnabled(true);
        binaryRadioButton.setEnabled(true);
        textField.setEnabled(true);
        label.setEnabled(true);
        buttonClear.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(true);
        buttonEight.setEnabled(true);
        buttonNine.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonFour.setEnabled(true);
        buttonFive.setEnabled(true);
        buttonSix.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonEqual.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(true);
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
        buttonE.setEnabled(true);
        buttonF.setEnabled(true);
        buttonNot.setEnabled(true);
        buttonAnd.setEnabled(true);
        buttonLeft.setEnabled(true);
        buttonOr.setEnabled(true);
        buttonRight.setEnabled(true);
        buttonXor.setEnabled(true);
    }

    public void DecimalSelected() { //When clicked to the 'Decimal' radio button:
        hexadecimalRadioButton.setEnabled(true);
        decimalRadioButton.setEnabled(false);
        binaryRadioButton.setEnabled(true);
        buttonClear.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(true);
        buttonEight.setEnabled(true);
        buttonNine.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonFour.setEnabled(true);
        buttonFive.setEnabled(true);
        buttonSix.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonEqual.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(true);
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        buttonE.setEnabled(false);
        buttonF.setEnabled(false);
        buttonNot.setEnabled(true);
        buttonAnd.setEnabled(false);
        buttonLeft.setEnabled(true);
        buttonOr.setEnabled(false);
        buttonRight.setEnabled(true);
        buttonXor.setEnabled(false);
    }

    public void BinarySelected(){ //When clicked to the 'Binary' radio button:
        hexadecimalRadioButton.setEnabled(true);
        decimalRadioButton.setEnabled(true);
        binaryRadioButton.setEnabled(false);
        buttonClear.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(false);
        buttonEight.setEnabled(false);
        buttonNine.setEnabled(false);
        buttonMul.setEnabled(true);
        buttonFour.setEnabled(false);
        buttonFive.setEnabled(false);
        buttonSix.setEnabled(false);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(false);
        buttonThree.setEnabled(false);
        buttonEqual.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(false);
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        buttonE.setEnabled(false);
        buttonF.setEnabled(false);
        buttonNot.setEnabled(true);
        buttonAnd.setEnabled(true);
        buttonLeft.setEnabled(true);
        buttonOr.setEnabled(true);
        buttonRight.setEnabled(true);
        buttonXor.setEnabled(true);
    }
}
