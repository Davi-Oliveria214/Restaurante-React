import styles from '../css/Carrossel.module.css'
import Card from '../components/Card'

export default function Carrossel() {
    return (
        <div className={styles.carrossel}>
            <button type='button' className={styles.btnLeft}>&lt;</button>
            <div className={styles.lista}>
                <Card />
                <Card />
                <Card />
                <Card />
                <Card />
                <Card />
                <Card />
                <Card />
                <Card />
                <Card />
            </div>
            <button type='button' className={styles.btnRight}>&gt;</button>
        </div>
    )
}