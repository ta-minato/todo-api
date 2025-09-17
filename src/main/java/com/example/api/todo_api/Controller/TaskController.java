package com.example.api.todo_api.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.todo_api.entity.Task;
import com.example.api.todo_api.service.TaskService;
@CrossOrigin(origins = "http://localhost:8080") // localhost:8080からのクロスオリジンリクエストを許可する
@RestController // このクラスがRESTfulなWebサービスのコントローラーであることを示す
public class TaskController { 
    @Autowired // Springが自動的に必要なオブジェクトをこのフィールドに注入
    TaskService taskService; 
    
    @GetMapping("/task") // HTTP GETリクエストを/taskのURLにマッピングする
    List<Task> getTasks(){ // すべてのタスクを取得するメソッド
        return taskService.findAllTask(); // タスクサービスを使用して全てのタスクを見つけて返す
    }
    
    @PostMapping("/task") // HTTP POSTリクエストを/taskのURLにマッピングする
    Task postTask(@RequestBody Task task){ // 新しいタスクを作成するメソッド
        return taskService.postTask(task); // タスクサービスを使用してタスクを保存し、結果を返す
    }
   
    @PutMapping("/task/{id}") // HTTP PUTリクエストを/task/{id}のURLにマッピングする
    Task putTask(@RequestBody Task task, @PathVariable int id){ // 既存のタスクを更新するメソッド
        return taskService.putTask(task, id); // タスクサービスを使用して指定されたIDのタスクを更新し、結果を返す
    }
    
    @DeleteMapping("/task/{id}") // HTTP DELETEリクエストを/task/{id}のURLにマッピングする
    void deleteTask(@PathVariable int id){ // 既存のタスクを削除するメソッド
        taskService.deleteTask(id); // タスクサービスを使用して指定されたIDのタスクを削除する
    }
}