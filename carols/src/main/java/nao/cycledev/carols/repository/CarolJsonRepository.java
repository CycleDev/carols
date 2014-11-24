package nao.cycledev.carols.repository;

import nao.cycledev.carols.model.Carol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CarolJsonRepository extends CarolRepository {

    private String json;

    public CarolJsonRepository(String json) {
        this.json = json;
    }

    @Override
    public void loadCarols() {

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray carols = (JSONArray) jsonObject.get("carols");
            for (int i = 0; i < carols.length(); i++) {
                JSONObject carol = carols.getJSONObject(i);
                if (carol != null) {
                    Carol objCarol = new Carol(
                            carol.getLong("id"),
                            carol.getString("title"),
                            carol.getString("text"),
                            carol.getString("info"));
                    addCarol(objCarol);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
