package searchengine.services;

import java.util.ArrayList;
import java.util.Arrays;

public class IndexingState {
    private boolean result;
    private String error;

    private ArrayList<String> results = new ArrayList<>(Arrays.asList("Индексация уже запущена", "Индексация не " +
            "запущена", "Данная страница находится за пределами сайтов, указанных в конфигурационном файле"));

    public IndexingState(boolean result, int i) {
        this.result = result;
        this.error = results.get(i);
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
