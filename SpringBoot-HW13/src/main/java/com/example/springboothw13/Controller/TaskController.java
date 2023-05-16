package com.example.springboothw13.Controller;


import com.example.springboothw13.ApiResponce.ApiResponce;
import com.example.springboothw13.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

ArrayList <Task> tasks = new ArrayList<>();


@GetMapping("/get")
public ArrayList <Task> getTask(){

    return tasks;
}

@PostMapping("/add")
public ApiResponce addTask(@RequestBody Task task){
   tasks.add(task);
   return new ApiResponce("data adeded");
}

@PutMapping("/update/{index}")
public ApiResponce updateTask(@PathVariable int index, @RequestBody Task task){
     tasks.set(index, task);
     return new ApiResponce("status updated");
}

@DeleteMapping("/delete/{index}")
    public ApiResponce deleteTask(@PathVariable int index){
    tasks.remove(index);
    return new ApiResponce("data deleted");
}
    @PutMapping("/status/{index}")
    public ApiResponce changeStatus(@PathVariable int index) {
        if (tasks.get(index).getStatus().equalsIgnoreCase("done")) {
            tasks.get(index).setStatus("not done");
            return new ApiResponce("update status");
        } else {
            tasks.get(index).setStatus("done");
            return new ApiResponce("update status");
        }
    }

    @GetMapping("/search/{title}")
    public ApiResponce search(@PathVariable String title) {
        for (Task task : tasks) {
            if (title.equals(task.getTitle())) {
                return new ApiResponce("found");
            }
        }
        return new ApiResponce("not found");
    }
}



