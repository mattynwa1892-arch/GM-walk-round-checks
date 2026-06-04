import { App } from "@octokit/app";
import express from "express";
import dotenv from "dotenv";

dotenv.config();

const app = express();
app.use(express.json());

// Initialize GitHub App
const githubApp = new App({
  appId: process.env.GITHUB_APP_ID,
  privateKey: process.env.GITHUB_APP_PRIVATE_KEY,
  webhooks: {
    secret: process.env.GITHUB_WEBHOOK_SECRET,
  },
});

// Health check endpoint
app.get("/api/health", (req, res) => {
  res.json({ status: "OK", message: "GitHub App is running" });
});

// Webhook endpoint
app.post("/api/webhook", async (req, res) => {
  const { id, name, payload } = req.body;

  console.log(`Received webhook: ${name}`);

  try {
    // Handle different webhook events
    if (name === "pull_request") {
      console.log("PR Event:", payload.action);
      // Add your PR logic here
    }

    if (name === "issues") {
      console.log("Issue Event:", payload.action);
      // Add your issue logic here
    }

    res.json({ success: true });
  } catch (error) {
    console.error("Webhook error:", error);
    res.status(500).json({ error: error.message });
  }
});

// Start server
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`GitHub App server running on port ${PORT}`);
  console.log(`Webhook URL: http://localhost:${PORT}/api/webhook`);
});
