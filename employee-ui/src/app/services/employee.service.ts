import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
  
  @Injectable({
    providedIn: 'root'
  })
  
  export class EmployeeService {
  
    private baseUrl = 'http://localhost:8090/emp-inv/api/';
  
    constructor(private http:HttpClient) { }
  
    getEmployeeList(): Observable<any> {
      return this.http.get(`${this.baseUrl}`+'employee');
    }
  
    createEmployee(employee: object): Observable<object> {
      return this.http.post(`${this.baseUrl}`+'employee', employee);
    }
  
    deleteEmployee(id: number): Observable<any> {
      return this.http.delete(`${this.baseUrl}/employee/${id}`, { responseType: 'text' });
    }
  
    getEmployee(id: number): Observable<Object> {
      return this.http.get(`${this.baseUrl}/employee/${id}`);
    }
  
    updateEmployee(id: number, value: any): Observable<Object> {
      return this.http.post(`${this.baseUrl}/employee/${id}`, value);
    }
    
  }                                           
