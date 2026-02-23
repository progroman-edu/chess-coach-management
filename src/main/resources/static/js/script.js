async function loadPlayers() {
    const list = document.getElementById("players-list");
    if (!list) {
        return;
    }

    try {
        const response = await fetch("/players");
        if (!response.ok) {
            throw new Error("Failed to load players");
        }

        const players = await response.json();
        list.innerHTML = "";

        if (players.length === 0) {
            list.innerHTML = "<li>No players found.</li>";
            return;
        }

        players.forEach((player) => {
            const item = document.createElement("li");
            item.textContent = `${player.name} (Rating: ${player.rating ?? "N/A"})`;
            list.appendChild(item);
        });
    } catch (error) {
        list.innerHTML = "<li>Could not load players.</li>";
    }
}

async function loadSessions() {
    const list = document.getElementById("sessions-list");
    if (!list) {
        return;
    }

    try {
        const response = await fetch("/sessions");
        if (!response.ok) {
            throw new Error("Failed to load sessions");
        }

        const sessions = await response.json();
        list.innerHTML = "";

        if (sessions.length === 0) {
            list.innerHTML = "<li>No sessions found.</li>";
            return;
        }

        sessions.forEach((session) => {
            const item = document.createElement("li");
            const playerName = session.player && session.player.name ? session.player.name : "Unassigned";
            item.textContent = `${session.topic ?? "No topic"} | ${session.durationMinutes ?? "?"} min | Player: ${playerName}`;
            list.appendChild(item);
        });
    } catch (error) {
        list.innerHTML = "<li>Could not load sessions.</li>";
    }
}

document.addEventListener("DOMContentLoaded", () => {
    loadPlayers();
    loadSessions();
});
