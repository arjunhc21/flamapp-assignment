async function loadFrame() {
    const resp = await fetch("mock_frame.json");
    return resp.json();
}

async function main() {
    const data = await loadFrame();
    const img = new Image();
    img.src = data.data_url;

    img.onload = () => {
        const canvas = document.getElementById("frameCanvas") as HTMLCanvasElement;
        const ctx = canvas.getContext("2d")!;
        ctx.drawImage(img, 0, 0, data.width, data.height);
    };
}

main();