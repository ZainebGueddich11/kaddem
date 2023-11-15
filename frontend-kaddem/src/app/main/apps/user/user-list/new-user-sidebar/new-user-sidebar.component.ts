import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { CoreSidebarService } from '@core/components/core-sidebar/core-sidebar.service';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Contrat} from "../../../../../shared/Model/Contrat";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {ContratService} from "../../../../../shared/Service/Contrat.service";
import {EquipeService} from "../../../../../shared/Service/Equipe.service";

@Component({
  selector: 'app-new-user-sidebar',
  templateUrl: './new-user-sidebar.component.html'
})
export class NewUserSidebarComponent implements OnInit {
  public clientForm: FormGroup;
  public registerSuccess: boolean = false;
  submitted = false;
  clients: any;
  value1: any;
  radioSelectedString: string;
  @Output() clientAdded = new EventEmitter();

  /**
   * Constructor
   *
   * @param {CoreSidebarService} _coreSidebarService
   */
  constructor(
      private _toastr: ToastrService,
      private _router: Router,
      private _coreSidebarService: CoreSidebarService,
      private formBuilder: FormBuilder,
      private equipeService : EquipeService
  ) {}

  /**
   * Toggle the sidebar
   *
   * @param name
   */
  /*toggleSidebar(name): void {
    this._coreSidebarService.getSidebarRegistry(name).toggleOpen();
  }

  /!**
   * Submit
   *
   * @param form
   *!/
  submit(form) {
    if (form.valid) {
      this.toggleSidebar('new-user-sidebar');
    }
  }
*/
  toggleSidebar(name): void {
    this.submitted = false;
    this._coreSidebarService.getSidebarRegistry(name).toggleOpen();
  }


  ngOnInit() {
    this.clientForm = this.formBuilder.group({
      nomEquipe: ['', Validators.required],
      niveau: ['', Validators.required],

    });
  }
  get f() { return this.clientForm.controls; }

  public submit(sideBarName: string) {
    this.submitted = true;
    if (this.clientForm.invalid) {
      return;
    }
    this.equipeService.addEquipe(this.clientForm.value).subscribe(
        (result) => {
          if (result) {
            this._toastr.success('Equipe added with success', 'Success');

            this._coreSidebarService.getSidebarRegistry(sideBarName).close();
            this._router.routeReuseStrategy.shouldReuseRoute = () => false;
            this._router.onSameUrlNavigation = 'reload';
            this._router.navigate(['/apps/user/user-list']);
          }
        },
        (error) => {
          console.log(error);
          this._toastr.error(this.errorMessage(error), 'Error');
        }
    );
  }

  private errorMessage(error: any): string {
    switch (error.status) {
      case 422:
        return error.error.errors.email ? 'Email address is already used' : 'Error while inserting, please verify your data';
      case 400:
        return 'Bad Request';
      default:
      case 500:
        return 'Internal Server Error';
    }
  }
  onReset() {
    this.submitted = false;
    this.clientForm.reset();
  }
}