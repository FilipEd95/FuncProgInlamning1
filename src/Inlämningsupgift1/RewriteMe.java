package Inlämningsupgift1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Inlämningsuppgit i kursen Funktionell Programmering för JAVA-programmet
För samtliga funktioner i denna fil, byt ut "throw UnSupportedException"-raden
och skriv ett pipeline-uttryck som returnerar det som ska returneras.
Streams MÅSTE användas i samtliga funktioner som lämnas in
För att testa om era funktioner funkar, kör testerna som hör till denna fil
För att bli godkänd på denna uppgift måste minst 7 av funktionerna vara implementerade.
Sigruns bedömning av denna uppgift kommer att gå till så att hon klipper in er version av denna fil
i sitt projekt och kör testerna.
Hennes kontroll om ni har klarat uppgifterna eller inte görs genom att
hon kollar att tillräckeligt många av tester går gröna. Pga detta ska ni inte ändra i någon fil
medföljande detta projekt, och inte heller metodsignaturerna i denna fil eller era tester, eftersom
ni då riskerar att påverka rättningen i negativ riktning.
 */

public class RewriteMe {

    public Database database = new Database();
    public List<Question> questions = database.getQuestions();

    //Skriv en funktion som returnerar hur många frågor det finns i databasen?      1. KLAR
    public int getAmountOfQuestionsInDatabase() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return (int) questions.stream().count();
    }

    //Hur många frågor finns i databasen för en viss, given kategori (som ges som inparameter)     2. KLAR
    public int getAmountOfQuestionsForACertainCategory(Category category) {
//        throw new UnsupportedOperationException("Not supported yet.");
        return (int) questions
                .stream()
                .filter(e -> e.getCategory()
                .equals(category))
                .count();
    }

    //Skapa en lista innehållandes samtliga frågesträngar i databasen      3. KLAR
    public List<String> getListOfAllQuestions() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return questions
                .stream()
                .map(e -> e.getQuestionString())
                .collect(Collectors.toList());
    }

    //Skapa en lista innehållandes samtliga frågesträngar där frågan tillhör en viss kategori       4. KLAR
    //Kategorin ges som inparameter
    public List<String> getAllQuestionStringsBelongingACategory(Category category) {
//        throw new UnsupportedOperationException("Not supported yet.");
        return questions.stream()
                .filter(e -> e.getCategory().equals(category))
                .map(Question::getQuestionString)
                .toList();
    }

    //Skapa en lista av alla svarsalternativ, där varje svarsalternativ får förekomma       5. KLAR
    // en och endast en gång i den lista som du ska returnera
    public List<String> getAllAnswerOptionsDistinct() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return questions
                .stream()
                .flatMap(e -> e.getAllAnswers()
                .stream())
                .distinct()
                .collect(Collectors.toList());
    }


    //Finns en viss sträng, given som inparameter, som svarsalternativ till någon fråga i vår databas?      6. KLAR
    public boolean isThisAnAnswerOption(String answerCandidate) {
//        throw new UnsupportedOperationException("Not supported yet.");
        return questions
                .stream()
                .anyMatch(e -> e.getAllAnswers()
                .contains(answerCandidate));
    }

    //Hur ofta förekommer ett visst svarsalternativ, givet som inparameter, i databasen
    public int getAnswerCandidateFrequncy(String answerCandidate) {
//        throw new UnsupportedOperationException("Not supported yet.");
        return (int) questions.stream()
                .flatMap(e -> e.answers.stream())
                .filter(e -> e.equals(answerCandidate)).count();
    }

    //Skapa en Map där kategorierna är nycklar och värdena är en lista
    //av de frågesträngar som tillhör varje kategori
    public Map<Category, List<String>> getQuestionGroupedByCategory() {
        throw new UnsupportedOperationException("Not supported yet.");
     /*   return  questions.stream().map(e -> e.getCategory()
                .equals(getQuestionGroupedByCategory()
                .values(Collectors.toMap()));*/
    }

    //Skapa en funktion som hittar det svarsalternativ som har flest bokstäver, i en kategori, given som inparameter
    // OBS: Du måste använda Reduce!
    public String getLongestLettercountAnwerInAGivenCategory(Category c) {
        throw new UnsupportedOperationException("Not supported yet.");
     /*   return questions
                .stream()
                .reduce(getLongestLettercountAnwerInAGivenCategory())
                .collect(Collectors.toList()).stream();*/
    }

    public static void main(String[] args) {
        RewriteMe uppg4 = new RewriteMe();
        System.out.println(uppg4.getAmountOfQuestionsInDatabase());
        System.out.println(uppg4.getAmountOfQuestionsForACertainCategory(Category.HISTORY));
        System.out.println(uppg4.getListOfAllQuestions());
        System.out.println(uppg4.getAllQuestionStringsBelongingACategory(Category.CHEMISTRY));
        System.out.println(uppg4.getAllAnswerOptionsDistinct());
    }
}