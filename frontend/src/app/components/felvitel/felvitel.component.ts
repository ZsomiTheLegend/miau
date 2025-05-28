import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-felvitel',
  templateUrl: './felvitel.component.html'
})
export class FelvitelComponent {
  ujKave = {
    nev: '',
    ar: null,
    suly: '',
    szarmazasiHely: '',
    darabSzam: null
  };
  hiba = '';

  constructor(private http: HttpClient, private router: Router) {}

  kuldes() {
    this.http.post('/api/v1/kave', this.ujKave).subscribe({
      next: () => this.router.navigate(['/termekek']),
      error: () => this.hiba = 'Nem sikerült a felvitel!'
    });
  }
}