package com.zava8.heksuletr.managers;
import com.zava8.heksuletr.model.HistoryResult;
import java.util.ArrayList;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class HistoryManager {
    private static final String DATABASE_NAME = "calculator.realm";
    private static final HistoryManager managerInstance = new HistoryManager();
    private RealmConfiguration config = new RealmConfiguration.Builder().name(DATABASE_NAME).build();
    private Realm realm = Realm.getInstance(config);
    private HistoryManager() {}
    public static HistoryManager getSharedInstance() { return managerInstance; } 
    public void printDatabaseLocation() { System.out.println("Realm db path: " + realm.getPath()); } 
    public void save(String resultString) {
        realm.beginTransaction();
        HistoryResult result = realm.createObject(HistoryResult.class);
        result.setResult(resultString); realm.commitTransaction();
    }
    public void deleteResult(HistoryResult resultToDelete) {
        RealmResults<HistoryResult> results = realm.where(HistoryResult.class).equalTo("id", resultToDelete.getId()).findAll();
        if (results.size() > 0) {
            realm.beginTransaction(); results.deleteAllFromRealm(); realm.commitTransaction();
        }
    }
    public ArrayList<HistoryResult> fetchAllHistoryResults() {
        return new ArrayList<HistoryResult>(realm.where(HistoryResult.class).findAll());
    }
}
