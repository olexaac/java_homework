package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Админ on 13.04.2018.
 */
public class TestBase {

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      System.out.println("Issue # " + issueId + " is not fixed");
      throw new SkipException("Ignored because of issue " + issueId);
    } else {
      System.out.println("Issue is fixed, U can test it");
    }
  }


  public boolean isIssueOpen(int issueId) throws IOException {
    return !getIssueById(issueId).getState_name().equals("Resolved");
  }

  public Issue getIssueById(int id) throws IOException {
    Issue issue = new Issue();
    getIssues()
            .stream().findFirst().map
            ((i) -> issue.withId(i.getId()).withSubject(i.getSubject())
                    .withDescription(i.getDescription())
                    .withStateName(i.getState_name()));
    return issue;
  }

  public Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
  }

  public Executor getExecutor() {
    return Executor.newInstance().auth("28accbe43ea112d9feb328d2c00b3eed", "");
  }
}

