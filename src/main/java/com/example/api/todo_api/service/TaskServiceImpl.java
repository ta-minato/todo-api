package com.example.api.todo_api.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.todo_api.entity.Task;
import com.example.api.todo_api.repository.TaskRepository;
@Service  // Springが管理するサービス層のクラスであるを表す
public class TaskServiceImpl implements TaskService {
    @Autowired  // Springが自動的にこの部分にTaskRepositoryクラスのインスタンスを設定する
    private TaskRepository taskRepository;
    
    @Override  // 親クラスのメソッドを上書き(オーバーライド)することを示す
    public List<Task> findAllTask(){  // 全てのタスクを取得するメソッド
        return taskRepository.findAll();  // データベースから全てのタスクを取得する
    }
    
    @Override
    public Task postTask(Task task){  // 新しいタスクを作成するメソッド
    return taskRepository.save(task);  // データベースに新しいタスクを保存する
    }
    
    @Override
    public Task putTask(Task task,int id){  // 既存のタスクを更新するメソッド
        Task updatedTask = taskRepository.findById(id).orElse(null);  // IDでタスクを検索し、存在しない場合はnullを返す
        updatedTask.setTask_name(task.getTask_name());  // タスクの名前を更新する
        updatedTask.setTask_detail(task.getTask_detail());  // タスクの詳細を更新する
        taskRepository.save(updatedTask);  // データベースに更新したタスクを保存する
        return updatedTask;  // 更新したタスクを返す
    }
    
    @Override
    public void deleteTask(int id){  // タスクを削除するメソッド
       taskRepository.deleteById(id);  // IDで指定したタスクをデータベースから削除する
    }
}