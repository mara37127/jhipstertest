import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: 'wishlist',
                loadChildren: './wishlist/wishlist.module#JhipsterTestWishlistModule'
            },
            {
                path: 'wishlist',
                loadChildren: './wishlist/wishlist.module#JhipsterTestWishlistModule'
            },
            {
                path: 'wishlist',
                loadChildren: './wishlist/wishlist.module#JhipsterTestWishlistModule'
            },
            {
                path: 'wishlist',
                loadChildren: './wishlist/wishlist.module#JhipsterTestWishlistModule'
            },
            {
                path: 'wish',
                loadChildren: './wish/wish.module#JhipsterTestWishModule'
            },
            {
                path: 'region',
                loadChildren: './region/region.module#JhipsterTestRegionModule'
            },
            {
                path: 'country',
                loadChildren: './country/country.module#JhipsterTestCountryModule'
            },
            {
                path: 'location',
                loadChildren: './location/location.module#JhipsterTestLocationModule'
            },
            {
                path: 'department',
                loadChildren: './department/department.module#JhipsterTestDepartmentModule'
            },
            {
                path: 'task',
                loadChildren: './task/task.module#JhipsterTestTaskModule'
            },
            {
                path: 'employee',
                loadChildren: './employee/employee.module#JhipsterTestEmployeeModule'
            },
            {
                path: 'job',
                loadChildren: './job/job.module#JhipsterTestJobModule'
            },
            {
                path: 'job-history',
                loadChildren: './job-history/job-history.module#JhipsterTestJobHistoryModule'
            }
            /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
        ])
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterTestEntityModule {}
