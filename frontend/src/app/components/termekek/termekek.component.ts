import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-termekek',
  templateUrl: './termekek.component.html'
})
export class TermekekComponent implements OnInit {
  kavak: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get<any[]>('/api/v1/kave').subscribe(data => {
      this.kavak = data;
    });
  }
}