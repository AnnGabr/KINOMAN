package gameManager;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import dbManager.DbAdapter;
import dbManager.tablesInfo.ComTestMode;

/**
 * Created by Ann on 04.04.2017.
 */

public class ComTestGameController {
    public static final int MAX_QUEST_COUNT = 2;
    private static Random rnd = new Random();

    private int score = 0;
    private Question quest = new Question();

    private int questCount;
    private String tableName;
    private DbAdapter dbAdapter;

    private ArrayList<Integer> questIdL = new ArrayList<Integer>();;
    private ArrayList<String> recommendL = new ArrayList<String>();;

    public ComTestGameController(int questCount, String tableName, DbAdapter dbAdapter){
        this.questCount = questCount;
        this.tableName = tableName;
        this.dbAdapter = dbAdapter;

        generateQuestList();
        it = questIdL.iterator();
    }

    private Iterator<Integer> it;
    //generate list of question ides
    private void generateQuestList(){
        for(int i = 0; i < questCount; ++i) {
            int id = rnd.nextInt(MAX_QUEST_COUNT) + 1;
            if(questIdL.contains(id))
                --i;
            else {
                questIdL.add(id);
            }
        }
    }

    //updates score according to chosen answer
    public void UpdateScore(String answer){
        if(answer == quest.rightAnswer)
            ++score;
        else
            recommendL.add(quest.rightAnswer);
    }

    //returns list of films which player don`t know well
    public ArrayList<String> getRecommend(){
        return recommendL;
    }

    public int getScore(){
        return score;
    }

    public int getQuestCount(){
        return questCount;
    }

    //check if the nest question exists
    public boolean hasNext(){
        return it.hasNext();
    }

    //returns next question object according to question ides list
    public Question nextQuestion(){
        quest.id = it.next();

        Cursor cursor = dbAdapter.getDataById(quest.id, tableName);
        if(cursor != null) {
            cursor.moveToFirst();

            quest.question = cursor.getString(cursor.getColumnIndex(ComTestMode.COLUMN_QUESTION));
            quest.rightAnswer = cursor.getString(cursor.getColumnIndex(ComTestMode.COLUMN_RIGHT_ANSWER));
            quest.img = cursor.getString(cursor.getColumnIndex(ComTestMode.COLUMN_IMG));
            quest.rightAnswer = cursor.getString(cursor.getColumnIndex(ComTestMode.COLUMN_RIGHT_ANSWER));

            quest.otherAnswers[0] = cursor.getString(cursor.getColumnIndex(ComTestMode.COLUMN_A));
            quest.otherAnswers[1] = cursor.getString(cursor.getColumnIndex(ComTestMode.COLUMN_B));
            quest.otherAnswers[2] = cursor.getString(cursor.getColumnIndex(ComTestMode.COLUMN_C));
        }
        cursor.close();

        return quest;
    }
}
