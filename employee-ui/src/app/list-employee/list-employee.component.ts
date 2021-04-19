import { Component, OnInit } from '@angular/core';
import { Observable,Subject } from "rxjs";

import {FormControl,FormGroup,Validators} from '@angular/forms';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../classes/employee';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  constructor(private employeeService:EmployeeService) { }

  private haveData= 0;

  private dataEmployee = [];
 

  ngOnInit() {
    this.getEmployees();
  }
  
  getEmployees()
  {
      this.haveData = 0;

      this.employeeService.getEmployeeList().subscribe(
          response => {

              let result = response;
              this.dataEmployee = result;

              if(result == " ")
              {
                  this.haveData = 0;
              }
              else
              {
                this.haveData = this.haveData + 1;
              }
          },
          error => {
              console.log("error while getting employee Data");
          }
      );
  }

}

