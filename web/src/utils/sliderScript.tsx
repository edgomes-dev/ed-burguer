import { useEffect } from 'react';

export function useSliderScript() {
  useEffect(() => {
    let settings = {
      firstItem: function () {
        let element = document.querySelector('#slider li:first-child');
        element?.classList.add('slider-active');
      },
      next: function () {
        let element = document.querySelector('.slider-active');

        if (element?.nextElementSibling) {
          element.nextElementSibling.classList.add('slider-active');
          element.classList.remove('slider-active');
        }
      },
      prev: function () {
        let element = document.querySelector('.slider-active');

        if (element?.previousElementSibling) {
          element.previousElementSibling.classList.add('slider-active');
          element.classList.remove('slider-active');
        }
      }
    };

    settings.firstItem();
    document
      .querySelector('#next')
      ?.addEventListener('click', settings.next, false);
    document
      .querySelector('#prev')
      ?.addEventListener('click', settings.prev, false);
  }, []);
}
