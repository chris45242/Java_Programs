import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class TriviaFrame extends JFrame{

    private JButton contestant1Button, contestant2Button, contestant3Button, contestant4Button, nextQuestionButton, submitAnswerButton;
    private JTextField questionTextField, answerTextField, contestant1ScoreTextField, contestant2ScoreTextField, contestant3ScoreTextField, contestant4ScoreTextField;
    private String questionAppeared, answerEntered;
    private JPanel panel, panel1, panel2, panel3;
    private JLabel correctAnswerLabel, wrongAnswerLabel;
    private Random randomQuestion = new Random();
    private JFrame f = new JFrame();

    JOptionPane pane = new JOptionPane();

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;

    private static final int FIELD_WIDTH = 2;

    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> answers = new ArrayList<>();
    int oldQuestion, score;

    public TriviaFrame()
    {
        super();
        oldQuestion = -1;
        score = 0;
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Trivia");
        loadQuestions();
        loadAnswers();
        createComponents();
        questionAppeared = "";
    }

// An array list of all the questions that will show up.
    private void loadQuestions()
    {
        questions.add("What is the name of the badlands in southern Utah?");// Chinle Badlands
        questions.add("Who invented video games?");// Ralph Baer
        questions.add("What kind of weapon is a Falchion?");// a sword
        questions.add("Where would you find the Sea of Tranquility?");// The moon
        questions.add("What country is Prague in?");// Czech Republic
        questions.add("What is the diameter of Earth?");// 8000 miles
        questions.add("Which actress won the most Oscars?");// Katharine Hepburn
        questions.add("Name the three primary colors?");// Red, yellow, and blue
        questions.add("What does the term piano mean?");// to be played softly
        questions.add("W is the chemical symbol of what element?");// Tungsten
        questions.add("Who played Neo in The Matrix?");// Keanu Reeves
        questions.add("When did the Cold War end?");// 1989
        questions.add("What is sushi traditionally wrapped in?");// Edible seaweed
    }

// An array list of all the answers to the questions.
    private void loadAnswers()
    {
        answers.add("Chinle Badlands");// What is the name of the badlands is southern Utah?
        answers.add("Ralph Baer");// Who invented Video Games?
        answers.add("a sword");// What kind of weapon is a Falchion?
        answers.add("the moon");// Where would you find the Sea of Tranquility?
        answers.add("Czech Republic");// What country is Prague in?
        answers.add("8000 miles");// What is the diameter of Earth?
        answers.add("Katharine Hepburn");// Which actress won the most Oscars?
        answers.add("Red, yellow, and blue");// Name the three primary colors?
        answers.add("to be played softly");// What does the term piano mean?
        answers.add("Tungsten");// W is the chemical symbol of what element?
        answers.add("Keanu Reeves");// Who played Neo in The Matrix?
        answers.add("1989");// When did the Cold War end?
        answers.add("Edible seaweed");// What is sushi traditionally wrapped in?
    }

// The ActionListener for changing which question will show up in the questionTextField.
    class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event){

// The ActionListener for the nextQuestion button.
            nextQuestionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e1) {
                    int q = randomQuestion.nextInt(13);
                    if (q == oldQuestion) {
                        q = randomQuestion.nextInt(13);
                    }
                    oldQuestion = q;
                    questionAppeared = questions.get(q);
                    questionTextField.setText(questionAppeared);
                    contestant1Button.setEnabled(true);
                    contestant1Button.setBackground(null);
                    contestant2Button.setEnabled(true);
                    contestant2Button.setBackground(null);
                    contestant3Button.setEnabled(true);
                    contestant3Button.setBackground(null);
                    contestant4Button.setEnabled(true);
                    contestant4Button.setBackground(null);
                    correctAnswerLabel.setVisible(false);
                    wrongAnswerLabel.setVisible(false);
                    answerTextField.setText("");
                }
            });

// The ActionListener for contestant 1's button.
            contestant1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contestant1Button = (JButton) e.getSource();
                    contestant1Button.setBackground(Color.RED);
                    contestant2Button.setEnabled(false);
                    contestant3Button.setEnabled(false);
                    contestant4Button.setEnabled(false);
                }
            });

// The ActionListener for contestant 2's button.
            contestant2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event1) {
                    contestant2Button = (JButton) event1.getSource();
                    contestant2Button.setBackground(Color.RED);
                    contestant1Button.setEnabled(false);
                    contestant3Button.setEnabled(false);
                    contestant4Button.setEnabled(false);
                }
            });

// The ActionListener for contestant 3's button.
            contestant3Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event2) {
                    contestant3Button = (JButton) event2.getSource();
                    contestant3Button.setBackground(Color.RED);
                    contestant1Button.setEnabled(false);
                    contestant2Button.setEnabled(false);
                    contestant4Button.setEnabled(false);
                }
            });

// The ActionListener for contestant 4's button.
            contestant4Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event3) {
                    contestant4Button =  (JButton) event3.getSource();
                    contestant4Button.setBackground(Color.RED);
                    contestant1Button.setEnabled(false);
                    contestant2Button.setEnabled(false);
                    contestant3Button.setEnabled(false);
                }
            });

// The ActionListener for the submit answer button.
            submitAnswerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event4) {
                    submitAnswerButton = (JButton) event4.getSource();
                    answerEntered = answerTextField.getText();
                if (answerEntered.equalsIgnoreCase(answers.get(oldQuestion))){
                    //correctAnswerLabel.setVisible(true);
                    JOptionPane.showMessageDialog(f, "Correct!");
                    if (contestant1Button.isBackgroundSet()){
                        contestant1ScoreTextField.setText(String.valueOf(score));
                        score++;
                    }
                    if (contestant2Button.isBackgroundSet()){
                        contestant2ScoreTextField.setText(String.valueOf(score));
                        score++;
                    }
                    if (contestant3Button.isBackgroundSet()){
                        contestant3ScoreTextField.setText(String.valueOf(score));
                        score++;
                    }
                    if (contestant4Button.isBackgroundSet()){
                        contestant4ScoreTextField.setText(String.valueOf(score));
                        score++;
                    }
                } else if (!answerEntered.equalsIgnoreCase(String.valueOf(answers))){
                    //wrongAnswerLabel.setVisible(true);
                    JOptionPane.showMessageDialog(f, "Wrong!");
                }
                }
            });
        }
    }

    private void createComponents()
    {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 4));
        panel1.setPreferredSize(new Dimension(20, 70));
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 4));
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(6, 1));

// Initializes the labels for getting the correct answer and the wrong answer.
        correctAnswerLabel = new JLabel("Correct!");
        correctAnswerLabel.setVisible(false);
        wrongAnswerLabel = new JLabel("Incorrect!");
        wrongAnswerLabel.setVisible(false);

// Initializes each of the contestants buttons and the next question button.
        submitAnswerButton = new JButton("Submit Answer");
        nextQuestionButton = new JButton("Next Question!");
        contestant1Button = new JButton("Contestant 1");
        contestant2Button = new JButton("Contestant 2");
        contestant3Button = new JButton("Contestant 3");
        contestant4Button = new JButton("Contestant 4");

// Initializes all the text fields for the questions the answers and the contestants scores.
        questionTextField = new JTextField();
        questionTextField.setPreferredSize(new Dimension(100, 25));
        questionTextField.setEditable(false);
        answerTextField = new JTextField();
        answerTextField.setPreferredSize(new Dimension(100, 25));
        contestant1ScoreTextField = new JTextField(FIELD_WIDTH);
        contestant1ScoreTextField.setEditable(false);
        contestant1ScoreTextField.setText(String.valueOf(score));
        contestant2ScoreTextField = new JTextField(FIELD_WIDTH);
        contestant2ScoreTextField.setEditable(false);
        contestant2ScoreTextField.setText(String.valueOf(score));
        contestant3ScoreTextField = new JTextField(FIELD_WIDTH);
        contestant3ScoreTextField.setEditable(false);
        contestant3ScoreTextField.setText(String.valueOf(score));
        contestant4ScoreTextField = new JTextField(FIELD_WIDTH);
        contestant4ScoreTextField.setEditable(false);
        contestant4ScoreTextField.setText(String.valueOf(score));

// adds the contestants buttons to panel #1.
        panel1.add(contestant1Button);
        panel1.add(contestant2Button);
        panel1.add(contestant3Button);
        panel1.add(contestant4Button);

// adds the contestants score boards to panel #2.
        panel2.add(contestant1ScoreTextField);
        panel2.add(contestant2ScoreTextField);
        panel2.add(contestant3ScoreTextField);
        panel2.add(contestant4ScoreTextField);

// adds the startGameButton, questions text field, and the text field to enter in your answers to panel #3.
        panel3.add(submitAnswerButton);
        panel3.add(nextQuestionButton);
        panel3.add(questionTextField);
        panel3.add(answerTextField);
        panel3.add(correctAnswerLabel);
        panel3.add(wrongAnswerLabel);

// adds all the panels to the JFrame.
        panel.add(panel1, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.PAGE_END);
        panel.add(panel3, BorderLayout.PAGE_START);
        this.add(panel);

// adds all the ClickListeners for all the buttons in the game.
        ActionListener listener = new ClickListener();
        nextQuestionButton.addActionListener(listener);
        ActionListener listener1 = new ClickListener();
        contestant1Button.addActionListener(listener1);
        ActionListener listener2 = new ClickListener();
        contestant2Button.addActionListener(listener2);
        ActionListener listener3 = new ClickListener();
        contestant3Button.addActionListener(listener3);
        ActionListener listener4 = new ClickListener();
        contestant4Button.addActionListener(listener4);
        ActionListener listener5 = new ClickListener();
        submitAnswerButton.addActionListener(listener5);
    }
}
