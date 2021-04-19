import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../classes/employee';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  private employee = new Employee();

  constructor(private employeeService : EmployeeService, private router : Router) { }

  ngOnInit() {
  }

  // create the form object.
  form = new FormGroup({
      name : new FormControl('' , Validators.required),
      age : new FormControl('' , Validators.required)
  });

  EmployeeForm(AdminInformation)
  {
        this.employee.name = this.Name.value;
        this.employee.age = this.Age.value;

        this.employeeService.createEmployee(this.employee).subscribe(
          response => {
              let result = response;
              console.log(result);

              if(result != null)
              {
                this.router.navigate(['/employee/list']);
              }
              else
              {
                  alert("Emplopyee failed to create")
              }
          },
          error => {
            alert("error occur while create employee. please try after sometime.")
          }
        );
  }


  get Name(){
    return this.form.get('name');
  }

  get Age(){
      return this.form.get('age');
  }
}
