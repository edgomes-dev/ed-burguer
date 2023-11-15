import { AdminBasetemplate } from '@/templates/Admin/AdminBaseTemplate';
import { AdminOrderHistorySummaryTemplate } from '@/templates/Admin/Order/History/AdminOrderHistorySummaryTemplate';

export default function historySummaryApp() {
  return (
    <AdminBasetemplate>
      <AdminOrderHistorySummaryTemplate />
    </AdminBasetemplate>
  );
}
