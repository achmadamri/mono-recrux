import { Component, OnInit } from '@angular/core';
import { Util } from 'app/util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html'
})
export class LogoutComponent implements OnInit {
  util: Util = new Util();

  constructor(private router: Router) { }

  ngOnInit() {
    this.util.logout();
    window.location.href = '/';
  }

}
