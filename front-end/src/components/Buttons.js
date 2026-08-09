import styles from '../css/Buttons.module.css'

export function Agendar() {
    return (
        <button type='button' className={`${styles.button} ${styles.btnAgendar}`}>Agendar</button>
    )
}

export function Detalhes() {
    return (
        <button type='button' className={`${styles.button} ${styles.btnDetalhes}`}>Detalhes</button>
    )
}