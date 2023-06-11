import { Component, OnInit } from '@angular/core';
import { DashboardService } from 'app/services/dashboard/dashboard.service';
import { GetDashboardRequest } from 'app/services/dashboard/getdashboardrequest';
import { GetDashboardResponse } from 'app/services/dashboard/getdashboardresponse';
import { Util } from 'app/util';
import * as Chartist from 'chartist';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {
  util: Util = new Util();
  getDashboardRequest: GetDashboardRequest = new GetDashboardRequest();
  getDashboardResponse: GetDashboardResponse = new GetDashboardResponse();

  constructor(
    private dashboardService: DashboardService
  ) { }

  startAnimationForLineChart(chart) {
    let seq: any, delays: any, durations: any;
    seq = 0;
    delays = 80;
    durations = 500;

    chart.on('draw', function (data) {
      if (data.type === 'line' || data.type === 'area') {
        data.element.animate({
          d: {
            begin: 600,
            dur: 700,
            from: data.path.clone().scale(1, 0).translate(0, data.chartRect.height()).stringify(),
            to: data.path.clone().stringify(),
            easing: Chartist.Svg.Easing.easeOutQuint
          }
        });
      } else if (data.type === 'point') {
        seq++;
        data.element.animate({
          opacity: {
            begin: seq * delays,
            dur: durations,
            from: 0,
            to: 1,
            easing: 'ease'
          }
        });
      }
    });

    seq = 0;
  };

  startAnimationForBarChart(chart) {
    let seq2: any, delays2: any, durations2: any;

    seq2 = 0;
    delays2 = 80;
    durations2 = 500;
    chart.on('draw', function (data) {
      if (data.type === 'bar') {
        seq2++;
        data.element.animate({
          opacity: {
            begin: seq2 * delays2,
            dur: durations2,
            from: 0,
            to: 1,
            easing: 'ease'
          }
        });
      }
    });

    seq2 = 0;
  };

  ngOnInit() {
    this.dashboardService.getDashboard()
      .subscribe(
        successResponse => {
          this.getDashboardResponse = successResponse;

          /* ----------==========     Daily Sales Chart initialization For Documentation    ==========---------- */
          const jobFillLabels = this.getDashboardResponse.lstViewDashJobFill.map(x => x.tbjName);
          const jobFillSeries = this.getDashboardResponse.lstViewDashJobFill.map(x => x.tbrCreateDateCount);

          var dataJobFillChart = {
            labels: jobFillLabels,
            series: [
              jobFillSeries
            ]
          };
          var optionsJobFillChart = {
            axisX: {
              showGrid: false
            },
            chartPadding: { top: 0, right: 5, bottom: 0, left: 0 },
            height: '300px',
          };
          var responsiveOptions: any[] = [
            ['screen and (max-width: 640px)', {
              seriesBarDistance: 5,
              axisX: {
                labelInterpolationFnc: function (value) {
                  return value[0];
                }
              }
            }]
          ];
          var jobFillChart = new Chartist.Bar('#jobFillChart', dataJobFillChart, optionsJobFillChart, responsiveOptions);

          //start animation for the Emails Subscription Chart
          this.startAnimationForBarChart(jobFillChart);

          /* ----------==========     Completed Tasks Chart initialization    ==========---------- */
          const completionLabels = this.getDashboardResponse.lstViewDashJobCompletion.map(x => x.status);
          const completionSeries = this.getDashboardResponse.lstViewDashJobCompletion.map(x => x.countData);

          const dataJobCompletionChart: any = {
            labels: completionLabels,
            series: completionSeries
          };

          const optionsJobCompletionChart: any = {
            labelInterpolationFnc: function (value) {
              return value;
            },
            height: '285px'
          };

          var jobCompletionChart = new Chartist.Pie('#jobCompletionChart', dataJobCompletionChart, optionsJobCompletionChart);

          // start animation for the Completed Tasks Chart - Pie Chart
          this.startAnimationForBarChart(jobCompletionChart);
        },
        errorResponse => {
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

}
