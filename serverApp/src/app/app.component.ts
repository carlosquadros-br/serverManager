import { DataState } from './enum/data-state.enum';
import { CustomResponse } from './interface/custom-response';
import { Observable, map, catchError } from 'rxjs';
import { AppState } from './interface/app-state';
import { OnInit } from '@angular/core';
import { ServerService } from './service/server.service';
import { Component } from '@angular/core';
import { startWith } from 'rxjs';
import { of } from 'rxjs';
import { Status } from './enum/status.enum';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  appState$: Observable<AppState<CustomResponse>>;
  readonly DataState = DataState;
  readonly Status = Status;

  constructor(private serverService: ServerService) {}

  ngOnInit(): void {
    this.appState$ = this.serverService.servers$
    .pipe(
      map((response) => {
        return { dataState: DataState.LOADED_STATE, appData: response };
      }),
      startWith({ dataState: DataState.LOADING_STATE }),
      catchError((error: string) => {
        return of({ dataState: DataState.ERROR_STATE, error });
      })
    );
  }
}
