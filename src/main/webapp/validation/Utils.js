export const Shapes = { TRIANGLE: 'triangle', SQUARE: 'square', SECTOR: 'sector' };

export function  changeClass (label, oldClass, newClass) {
    label.classList.remove(oldClass)
    label.classList.add(newClass)
}