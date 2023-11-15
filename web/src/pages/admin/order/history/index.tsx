import { AdminBasetemplate } from '@/templates/Admin/AdminBaseTemplate';
import { AdminOrderHistoryTemplate } from '@/templates/Admin/Order/History/AdminOrderHistoryTemplate';

export default function historyApp() {
  return (
    <AdminBasetemplate>
      <AdminOrderHistoryTemplate />
    </AdminBasetemplate>
  );
}
