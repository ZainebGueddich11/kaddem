import { CoreMenu } from '@core/types';

//? DOC: http://localhost:7777/demo/vuexy-angular-admin-dashboard-template/documentation/guide/development/navigation-menus.html#interface

export const menu: CoreMenu[] = [

  // Apps & Pages

    {
        id: 'apps',
        type: 'section',
        title: 'Apps & Pages',
        translate: 'MENU.APPS.SECTION',
        icon: 'package',
        children: [

            {
                        id: 'contrat',
                        title: 'Contrat',
                        translate: 'MENU.APPS.USER.LIST',
                        type: 'item',
                        icon: 'file',
                        url: 'apps/user/user-list'

            }
        ]
    }



];
