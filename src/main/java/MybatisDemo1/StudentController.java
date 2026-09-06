package MybatisDemo1;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
   @Autowired
   private StudentService studentService;
    @GetMapping("/students")
    public Result getAll(){
        return Result.success(studentService.findAll());
    }

    @GetMapping("/students/{id}")
    public Result getById(@PathVariable Integer id){
        Student s= studentService.findById(id);
        if(s==null){
            return Result.error("该用户不存在！请重新输入！");
        }else {
            return Result.success(s);
        }
    }

    @PostMapping("/students")
    public Result insert(@RequestBody Student student){
        studentService.insert(student);
        return Result.success(student);
    }

    @PutMapping("/students")
    public Result update(@RequestBody Student student){
        int rows= studentService.update(student);
        if(rows==0){
            return Result.error("更新失败！");
        }else {
            return Result.success(null);
        }
    }

    @DeleteMapping("/students/{id}")
    public Result deleteById(@PathVariable Integer id){
        int rows = studentService.deleteById(id);
        if(rows==0){
            return Result.error("删除失败！");
        }else {
            return Result.success(null);
        }
    }

    @GetMapping("/students/search")
    public Result search(@RequestParam(required = false) String name,
                                @RequestParam(required = false) Integer id){
        boolean flag = studentService.search(name, id).isEmpty();
        if (flag){
            return Result.error("不存在这样的学生！");
        }else {
            return Result.success(studentService.search(name, id));
        }
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public Result login(@RequestBody Manager manager){
        int i =studentService.login(manager);
        if (i==1){
            return Result.success(null);
        }else {
            return Result.error( "账号或密码错误！请重试！");
        }
    }

}
