import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoffeeService {
  private apiUrl = '/api/v1';

  constructor(private http: HttpClient) { }

  getCoffees(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/kvs`);
  }

  addCoffee(coffee: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/kv`, coffee);
  }
}
